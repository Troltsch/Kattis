package Kattis.thanos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class thanos {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException 
    {
      int T = Integer.parseInt(br.readLine());

      for(int i=0;i<T;++i)
      {
        String[] input = br.readLine().split(" ");
        long P = Long.parseLong(input[0]);
        long R = Long.parseLong(input[1]);
        long F = Long.parseLong(input[2]);

        int counter = 0;
        long people = P;
        while(people <= F)
        {
          people *= R;
          ++counter;
        }
        System.out.println(counter);
      }
    }
}