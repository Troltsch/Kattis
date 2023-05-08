package Kattis.pseudoprime;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class pseudoprime {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Long, Boolean> primeMap = new HashMap<Long, Boolean>();
    static ArrayList<Long> primes = new ArrayList<Long>();

    static boolean isPrime(int num) {
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws IOException {
        while (true) {
            String[] lineTokens = br.readLine().split(" ");
            long p = Long.parseLong(lineTokens[0]);
            long a = Long.parseLong(lineTokens[1]);
            if ((a == 0) && (p == 0))
                break;

            if (isFermatPseudoprime(p, a)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();

    }

    public static boolean isFermatPseudoprime(long p, long a) {
        // Calculate a^(p-1) modulo p
        long apMinusOneModP = 1;
        for (int i = 0; i < p - 1; i++) {
            apMinusOneModP = (apMinusOneModP * a) % p;
        }

        // Check if a^(p-1) is congruent to 1 modulo p
        if (apMinusOneModP != 1) {
            return false;
        }

        // Check if p is a Fermat pseudoprime with respect to base a
        long x = a % p;
        for (int i = 1; i <= p - 2; i++) {
            x = (x * a) % p;
            if (x == 1) {
                return true;
            }
        }
        return false;
    }

    public static HashMap<Long, Integer> primeFactors(long number) {
        HashMap<Long, Integer> factors = new HashMap<Long, Integer>();

        for (int i = 0; i < primes.size();) {
            var prime = primes.get(i);
            if (number % prime == 0) {
                number /= prime;

                if (factors.containsKey(prime)) {
                    int count = factors.get(prime);
                    factors.put(prime, count + 1);
                } else {
                    factors.put(prime, 1);
                }
            } else {
                ++i;
            }
        }

        if (number != 1) {
            factors.put(number, 1);
        }

        return factors;
    }

    static boolean isPrime(long n) {
        if (primeMap.containsKey(n))
            return primeMap.get(n);

        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                primeMap.put(n, false);
                return false;
            }
            ++i;
        }
        primeMap.put(n, true);
        return true;
    }

}
