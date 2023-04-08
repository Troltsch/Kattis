package Kattis.fractalarea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class fractalarea {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;++i)
        {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            BigDecimal bigDecimalR = new BigDecimal(r);
            BigDecimal bigDecimalA = new BigDecimal(0);
            BigDecimal tinyCircles = new BigDecimal(12);
            
            for(int j=0;j<n;++j)
            {
                BigDecimal newR = bigDecimalR.divide(new BigDecimal(2).pow(j));
                BigDecimal circleSize = newR.pow(2).multiply(new BigDecimal(Math.PI));

                if(j == 0) bigDecimalA = bigDecimalA.add(circleSize);
                else if(j == 1) bigDecimalA = bigDecimalA.add(circleSize.multiply(new BigDecimal(4)));
                else if(j >= 1)
                {
                    bigDecimalA = bigDecimalA.add(circleSize.multiply(tinyCircles));
                    tinyCircles = tinyCircles.multiply(new BigDecimal(3));
                } 
            }
            
            System.out.println(bigDecimalA);
        }
    }
}