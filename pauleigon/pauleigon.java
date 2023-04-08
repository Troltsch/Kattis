package Kattis.pauleigon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;

public class pauleigon {
    static Scanner sc = new Scanner(System.in);
    
    public static void main(String args[]) throws IOException 
    {
        long N = sc.nextLong();
        long P = sc.nextLong();
        long Q = sc.nextLong();

        long sum = P+Q;

        if((sum/N) % 2 == 0) System.out.println("paul");
        else System.out.println("opponent");

    }
}