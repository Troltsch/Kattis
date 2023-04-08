package Kattis.character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class character {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static long recRel(long currentN, long maxN)
    {
        if(currentN > maxN) return 0;

        if(currentN == 0 || currentN == 1) return recRel(currentN+1, maxN);
        
        System.out.print(((currentN-1)*currentN / 2) + " + ");
        return recRel(currentN+1, maxN) + ((currentN-1)*currentN / 2);
    }

    public static long recRel2(ArrayList<Long> list, long currentN, long maxN)
    {
        if(currentN == maxN) return 0;

        ArrayList<Long> newList = new ArrayList<Long>();

        //long val = (currentN-1)*currentN / 2;
        //list.add(val);
        newList.add(currentN+list.get(0));
        for(int i=0;i<list.size()-1;++i)
        {
            newList.add(list.get(i) + list.get(i+1));
        }
        newList.add(1l);
        
        long sum = 0;
        for(int i=0;i<newList.size();++i) sum += newList.get(i);

        return sum + recRel2(newList, currentN+1, maxN);
    }

    public static void main(String args[]) throws IOException 
    {
        long chars = sc.nextLong();
        if(chars == 0 || chars == 1)
        {
            System.out.println(0);
            return;
        }

        ArrayList<Long> list = new ArrayList<Long>();
        list.add(1l);
        for(int i=3;i<=chars;++i)
        {
            ArrayList<Long> newList = new ArrayList<Long>();
            long prevNumb = (i-1);
            newList.add(prevNumb+list.get(0));
            for(int j=1;j<list.size();++j) newList.add(list.get(j-1)+list.get(j));
            newList.add(1l);

            list = newList;
        }
        long sum = 0;
        for(Long val : list) sum += val;
         
        System.out.println(sum);
    }
}