package Kattis.dualdivisibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

public class dualdivisibility {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    

    public static void main(String args[]) throws IOException 
    {
      BigInteger a = new BigInteger(sc.next());
      BigInteger b = new BigInteger(sc.next());

      int numberOfDivisors = 0;

      int counter = 1;
      while(true)
      {
        BigInteger times = new BigInteger(counter+"");
        BigInteger divisor = b.multiply(times);

        if(divisor.compareTo(a) == 1) break;

        if(a.mod(divisor) == BigInteger.ZERO) ++numberOfDivisors;
        ++counter;
      }

      System.out.println(numberOfDivisors);

    }
}