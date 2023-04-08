package Kattis.howmanydigits;
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

public class howmanydigits {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    static ArrayList<Integer> results = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException 
    {
        BigInteger bg = BigInteger.ONE;
       for(int i=2;i<=100000;++i)
       {
        bg = bg.multiply(new BigInteger(i+""));
       }
       System.out.println("Done");
    }
}