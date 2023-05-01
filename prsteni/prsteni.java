package Kattis.prsteni;

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

public class prsteni {
    // static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        int A = arr[0];
        for (int i = 1; i < n; ++i) {
            int B = arr[i];
            int gcd = gcdThing(A, B);
            int aGcd = A / gcd;
            int bGcd = B / gcd;
            System.out.println(aGcd + "/" + bGcd);
        }
    }

    private static int gcdThing(int a, int b) {
        BigInteger b1 = BigInteger.valueOf(a);
        BigInteger b2 = BigInteger.valueOf(b);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();
    }
}