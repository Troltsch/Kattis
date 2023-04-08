package Kattis.matrix;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class matrix {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Integer> results = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException 
    {
       String input;
       int caseNo = 1;
       while((input = br.readLine()) != null)
       {
        String[] first = input.split(" ");
        String[] second = br.readLine().split(" ");

        int a = Integer.parseInt(first[0]);
        int b = Integer.parseInt(first[1]);
        int c = Integer.parseInt(second[0]);
        int d = Integer.parseInt(second[1]);
        
        double M = a*d - b*c;
        M = 1/M;
        System.out.println("Case " + caseNo + ":");
        System.out.println((int)(M*d) + " " + (int)(-M*b));
        System.out.println((int)(-M*c) + " " + (int)(M*a));

        br.readLine();
        ++caseNo;
       }
    }
}