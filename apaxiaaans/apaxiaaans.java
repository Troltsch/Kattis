package Kattis.apaxiaaans;
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

public class apaxiaaans {
    //static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
       String input = br.readLine();
       char lastChar = input.charAt(0);
       System.out.print(lastChar);
       for(int i=1;i<input.length();++i)
       {
        char currentChar = input.charAt(i);
        if(lastChar == currentChar) continue;
        lastChar = currentChar;
        System.out.print(lastChar);
       }
       System.out.println();
    }
}