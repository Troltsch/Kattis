package Kattis.cprnummer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;
import java.util.Map.Entry;

public class cprnummer {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
       String input = br.readLine();
       int c1 = Integer.parseInt(input.charAt(0)+"");
       int c2 = Integer.parseInt(input.charAt(1)+"");
       int c3 = Integer.parseInt(input.charAt(2)+"");
       int c4 = Integer.parseInt(input.charAt(3)+"");
       int c5 = Integer.parseInt(input.charAt(4)+"");
       int c6 = Integer.parseInt(input.charAt(5)+"");

       int c7 = Integer.parseInt(input.charAt(7)+"");
       int c8 = Integer.parseInt(input.charAt(8)+"");
       int c9 = Integer.parseInt(input.charAt(9)+"");
       int c10 = Integer.parseInt(input.charAt(10)+"");

       int sum = 4*c1 + 3*c2 + 2*c3 + 7*c4 + 6*c5 + 5*c6 + 4*c7 + 3*c8 + 2*c9 + c10;
       
       if(sum%11 == 0 ) System.out.println(1);
       else System.out.println(0);
    }
}