package Kattis.pathcrossings;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class pathcrossings {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        String[] input = br.readLine().split(" ");
        int people =  Integer.parseInt(input[0]);
        int N =  Integer.parseInt(input[1]);

        ArrayList<Ping> pings = new ArrayList<Ping>();
        for(int i=0;i<N;++i)
        {
            String[] arr = br.readLine().split(" ");
            int id = Integer.parseInt(arr[0]);
            long x = Long.parseLong(arr[1]);
            long y = Long.parseLong(arr[2]);
            long t = Long.parseLong(arr[3]);
            
            pings.add(new Ping(id, x, y, t));
        }

        Collections.sort(pings, new Ping());

        HashSet<Pair> set = new HashSet<Pair>();
        for(int i=0;i<pings.size();++i)
        {
            Ping a = pings.get(i);
            //System.out.println(a.id);
            for(int j=i+1;j<pings.size();++j)
            {
                Ping b = pings.get(j);
                if(a.equals(b) || a.id == b.id) continue;
                if((b.t - a.t) > 10) break;

                double dist = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
                if(dist > 1000.) continue;

                if(a.id < b.id) set.add(new Pair(a.id, b.id));
                else set.add(new Pair(b.id, a.id));
            }   
        }

        ArrayList<Pair> pairs = new ArrayList<Pair>();
        for(Pair entry : set)
        {
            pairs.add(entry);
        }
        Collections.sort(pairs, new Pair());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(pairs.size() + "\n");
        for(Pair pair : pairs)
        {
            bw.write(pair.id_a + " " + pair.id_b + "\n");
        }
        bw.flush();
    }

    public static class Pair implements Comparator<Pair>
    {
        Pair(){}
        Pair(int a, int b)
        {
            this.id_a = a;
            this.id_b = b;
        }
        int id_a;
        int id_b;
        @Override
        public int compare(Pair o1, Pair o2) {
            if(o1.id_a == o2.id_a)
            {
                if(o1.id_b < o2.id_b) return -1;
                if(o1.id_b > o2.id_b) return 1;
                return 0;
            }
            if(o1.id_a < o2.id_a) return -1;
            if(o1.id_a > o2.id_a) return 1;
            return 0;
        }

        @Override
        public boolean equals(Object other) 
        { 
            return (hashCode() == other.hashCode());
        }

        @Override
        public int hashCode() {
            return (id_a + " " + id_b).hashCode();
        }
    }

    public static class Ping implements Comparator<Ping>
    {
        Ping(){};
        Ping(int id, long x, long y, long t)
        {
            this.id = id;
            this.x = x;
            this.y = y;
            this.t = t;
        }
        int id;
        long x;
        long y;
        long t;
        @Override
        public int compare(Ping o1, Ping o2) {
            if(o1.t < o2.t) return -1;
            if(o1.t > o2.t) return 1;
            return 0;
        }
    }
}