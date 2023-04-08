package tripodometer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;

class tripodometer {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException {
       int N = Integer.parseInt(br.readLine());
       String[] vals = br.readLine().split(" ");

       int total = 0;
       HashSet<Integer> set = new HashSet<Integer>();
       
       for(int i = 0;i<N;++i)
       {
            int val = Integer.parseInt(vals[i]);
            set.add(val);
            total += val;
       }

       ArrayList<Integer> values = new ArrayList<Integer>();
       for(Integer integer : set)
       {
        values.add(total - integer);
       }

       Collections.sort(values);

       System.out.println(set.size());
       boolean first = true;
       for(Integer integer : values)
       {
        if(first){
            System.out.print(integer);            
            first = false;
        } 
        else System.out.print(" " + integer);
       }
    }
}
