package Kattis.aboveaverage;
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

public class aboveaverage {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        int N = sc.nextInt();
        for(int i=0;i<N;++i)
        {
            int M = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<Integer>();
            int sum = 0;
            for(int j=0;j<M;++j)
            {
                int val = sc.nextInt();
                list.add(val);
                sum += val;
            }
            double avg = sum/M;
            double count = 0;
            for(int j=0;j<M;++j)
            {
                if(list.get(j) > avg) ++count;
            }
            double total = count/M*100;
            total = Math.round(total*1000)/1000.;
            System.out.printf("%.3f%%\n",total);
        }
        
    }
}