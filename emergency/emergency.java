package Kattis.emergency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


class emergency {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    //static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] input = br.readLine().split(" ");

        BigInteger N = new BigInteger(input[0]);
        BigInteger K = new BigInteger(input[1]);
        
        N = N.subtract(BigInteger.ONE);

        BigInteger border = K.multiply(BigInteger.TWO).subtract(K.divide(BigInteger.TWO));
        if(N.compareTo(border) <= 0)
        {
            System.out.println(N);
            return;
        }
        
        BigInteger minTimes = N.divide(K);                              // 100/3 -> 33
        BigInteger minVal = minTimes.multiply(K);                       // 33*3 -> 99
        System.out.println(K.add(BigInteger.ONE).add(N.subtract(minVal))); // K + 1 + lesserDiff
    }
}
