package Kattis.pickupsticks;
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
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class pickupsticks {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        String[] input = br.readLine().split(" ");
        int stickNumber = Integer.parseInt(input[0]);
        int lines =  Integer.parseInt(input[1]);

        ArrayList<Stick> sticks = new ArrayList<Stick>();
        for(int i=1;i<=stickNumber;++i)
        {
            sticks.add(new Stick(i));
        }

        for(int i=0;i<lines;++i)
        {
            String[] input2 = br.readLine().split(" ");
            int stickTopNo = Integer.parseInt(input2[0]);
            int stickBottomNo =  Integer.parseInt(input2[1]);
            
            Stick stickTop = sticks.get(stickTopNo-1);
            Stick stickBottom = sticks.get(stickBottomNo-1);

            stickBottom.topSticks.add(stickTop);
            stickTop.bottomSticks.add(stickBottom);
        }

        LinkedList<Stick> stickQueue = new LinkedList<Stick>();
        for(Stick stick : sticks)
        {
            if(stick.topSticks.size() == 0) stickQueue.add(stick);
        }

        
        ArrayList<Stick> solution = new ArrayList<Stick>();

        while(stickQueue.size() > 0)
        {
            Stick stick = stickQueue.pop();
            for(Stick bottomStick : stick.bottomSticks)
            {
                bottomStick.topSticks.remove(stick);
                if(bottomStick.topSticks.size() == 0)
                {
                    stickQueue.add(bottomStick);
                }
            }
            solution.add(stick);
            sticks.remove(stick);
        }

        if(sticks.size() > 0)
        {
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(Stick stick : solution)
        {
            bw.write(stick.id + "\n");
        }
        bw.flush();
    }

    public static class Stick
    {
        Stick(int id)
        {
            this.id = id;
        }

        int id;
        ArrayList<Stick> topSticks = new ArrayList<Stick>();
        ArrayList<Stick> bottomSticks = new ArrayList<Stick>();
    }
}