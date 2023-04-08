package Kattis.simpleaddition;
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

public class simpleaddition {
    static Scanner sc = new Scanner(System.in);
    //static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String args[]) throws IOException 
    {
        BigInteger bgA = new BigInteger(sc.nextLine());    
        BigInteger bgB = new BigInteger(sc.nextLine());
        System.out.println(bgA.add(bgB));
    }

    
}