package toflur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class toflur {
    //public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
        long N = sc.nextLong();
        
        ArrayList<Long> vals = new ArrayList<Long>();
        for(int i=0;i<N;++i) vals.add(sc.nextLong());

        Collections.sort(vals);  

      //  System.out.println(vals);
        long total = 0;
        for(int i=0;i<N-1;++i)
        {
            long cur = vals.get(i);
            long next = vals.get(i+1);

            long dif = (long) Math.pow(cur - next,2);
            total += dif;
            //System.out.println(cur + " " + next + "=" + dif);
            //System.out.println(total + " " + dif);
        }
        System.out.println(total);
    }
}
