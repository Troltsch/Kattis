package Kattis.parket;

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

public class parket {
    static Scanner sc = new Scanner(System.in);
    // static BufferedReader br = new BufferedReader(new
    // InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        int R = sc.nextInt();
        int B = sc.nextInt();

        int sum = R + B;

        for (int i = 3; i < sum; ++i) {
            if (sum % i == 0) {
                int W = i;
                int H = sum / i;
                int reds = 2 * (W + H) - 4;
                if (reds == R) {
                    System.out.println(Math.max(W, H) + " " + Math.min(W, H));
                    break;
                }
            }
        }
    }
}