package Kattis.parking2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class parking2 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws NumberFormatException, IOException 
    {
        int testCases = Integer.parseInt(br.readLine());
        for(int i=0;i<testCases;++i)
        {
            int n = Integer.parseInt(br.readLine());
            String[] strings = br.readLine().split(" ");
            int min = Integer.parseInt(strings[0]);
            int max = min;
            for(int j=1;j<n;++j)
            {
                int val = Integer.parseInt(strings[j]);
                if(val < min) min = val;
                if(val > max) max = val;
            }
            System.out.println((max - min) * 2);
        }
    }
}

/*
2
4
24 13 89 37
6
7 30 41 14 39 42

*/