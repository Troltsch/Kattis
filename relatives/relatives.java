package Kattis.relatives;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class relatives {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Long> primes = new ArrayList<Long>();

    private static boolean isPrime(long n) {
        if (n == 1)
            return false;

        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            ++i;
        }
        return true;
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

    public static void main(String args[]) throws IOException {
        for (int i = 2; i < 65555; ++i) {
            if (isPrime(i))
                primes.add((long) i);
        }

        while (true) {
            long n = sc.nextLong();
            if (n == 0)
                break;

            var factors = primeFactors(n);
            int coPrime = 1;
            for (var factorEntry : factors.entrySet()) {
                var factor = factorEntry.getKey();
                var count = factorEntry.getValue();
                coPrime *= Math.pow(factor, (count - 1)) * (factor - 1);
            }
            System.out.println(coPrime);
        }
    }

}