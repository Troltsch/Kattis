package knitpicking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Map.Entry;

class knitpicking {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(br.readLine());

        ArrayList<Sock> socks = new ArrayList<Sock>();
        for(int i=0;i<N;++i)
        {
            String[] input = br.readLine().split(" ");
            String type = input[0];
            String fit = input[1];
            int number = Integer.parseInt(input[2]);

            Sock sock = new Sock(type, fit, number);
            socks.add(sock);
        }
        
        Collections.sort(socks, Comparator.reverseOrder());

        HashSet<String> usedType = new HashSet<String>();
        HashMap<String, Sock> map = new HashMap<String, Sock>();
        int total = 0;

        Sock usedSock = null;
        // first iteration:
        // Only left and right
        for(Sock sock : socks)
        {
            if(sock.fit.equals("any")) continue;
            
            if(!map.containsKey(sock.type))
            {
                map.put(sock.type, sock);
                total += sock.number;
            }               
        }
        for(Entry<String, Sock> entry : map.entrySet())
        {
            socks.remove(entry.getValue());
        }
        
        // Now check any-category
        for(Sock sock : socks)
        {
            if(!sock.fit.equals("any")) continue;

            if(!map.containsKey(sock.type))
            {
                // Take one sock
                map.put(sock.type, sock);
                total += 1;
                sock.number -= 1;
            }   
        }

        // Finally find the last sock
        boolean solveable = false;
        for(Sock sock : socks)
        {
            if(map.containsKey(sock.type))
            {
                Sock target = map.get(sock.type);
                if(target.number == 0) continue;
                total += 1;
                solveable = true;
                break;
            }
        }

        if(!solveable) System.out.println("impossible");
        else System.out.println(total);
    }

    public static class Sock implements Comparable<Sock>{
        Sock(String type, String fit, int number)
        {
            this.type = type;
            this.fit = fit;
            this.number = number;
        }
        String type;
        String fit;
        int number;

        public int compareTo(Sock other) 
        {
            return this.number - other.number; 
        }	
    }

}
