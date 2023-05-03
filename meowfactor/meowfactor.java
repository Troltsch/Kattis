package Kattis.meowfactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class meowfactor {
    // static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        long n = Long.parseLong(br.readLine());
        System.out.println(getMeowFactor(n));
    }

    static long getMeowFactor(long n) {
        long start = (long) Math.ceil(nthRoot(9, n));
        for (long i = start; i >= 1; --i) {
            long tmp = n;
            for (long j = 0; j < 9; ++j) {
                if (tmp % i != 0)
                    break;

                tmp /= i;

                if (j == 8)
                    return i;
            }
        }
        return 1;
    }

    public static double nthRoot(int n, double k) {
        if (n == 0) {
            return Double.NaN; // undefined
        } else if (n % 2 == 0 && k < 0) {
            return Double.NaN; // undefined
        } else if (k == 0) {
            return 0; // special case
        } else {
            double x = Math.pow(Math.abs(k), 1.0 / n);
            return k < 0 ? -x : x;
        }
    }
}
