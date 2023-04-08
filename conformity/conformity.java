package Kattis.conformity;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class conformity {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) throws IOException 
    {
       int N = sc.nextInt();
       HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
       for(int i=0;i<N;++i)
       {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(sc.nextInt());
        list.add(sc.nextInt());
        list.add(sc.nextInt());
        list.add(sc.nextInt());
        list.add(sc.nextInt());
        Collections.sort(list);
        int key = list.hashCode();
        if(map.containsKey(key))
        {
            map.put(list.hashCode(), map.get(key)+1);
        }
        else map.put(key, 1);
       }

       int max = 0;
       for(Entry<Integer, Integer> entry : map.entrySet())
       {
        Integer val = entry.getValue();
        if (val > max) max = val;
       }

       int sum = 0;
       for(Entry<Integer, Integer> entry : map.entrySet())
       {
        if(entry.getValue() == max)
        {
            sum += entry.getValue();
        }
       }
       System.out.println(sum);
    }
}