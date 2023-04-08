package Kattis.password;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class password {
    static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String args[]) throws IOException 
    {
        int n = Integer.parseInt(br.readLine());
        ArrayList<Double> list = new ArrayList<Double>();
        for(int i=0;i<n;++i)
        {
            list.add(Double.parseDouble(br.readLine().split(" ")[1]));
        }

        Collections.sort(list);
        Collections.reverse(list);

        double sum=0.0;
        for(int i=0;i<n;++i)
        {
            sum += (i+1) * list.get(i);
        }
        System.out.println(sum);
    }
}