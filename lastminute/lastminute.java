package Kattis.lastminute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


class lastminute {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws NumberFormatException, IOException 
    {
        long uniqueA = sc.nextLong();
        long uniqueB = sc.nextLong();
        long reuseA = sc.nextLong();
        long reuseB = sc.nextLong();

        long sum = 0;

        if(uniqueB>0 && reuseA>0)
        {
            sum+=uniqueB;
            uniqueB = 0;
        } 
        if(uniqueA>0 && reuseB>0)
        {
            sum+=uniqueA;
            uniqueA = 0;
        }        
        sum += Math.min(uniqueA, uniqueB);
        sum += reuseA*reuseB;

        System.out.println(sum);
    }
}
