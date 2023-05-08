package Kattis.pascal;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class pascal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {
        long N = sc.nextLong();

        long result = pascal(N);
        System.out.println(result);
    }

    private static long pascal(long N) {
        if (N == 1) {
            return 0;
        }

        if (N % 2 == 0) {
            return N / 2;
        }

        if (isPrime(N)) {
            return N - 1;
        }

        var factors = primeFactors(N);
        long maxFactor = 0;
        for (var factorEntry : factors.entrySet()) {
            var factor = factorEntry.getKey();
            var count = factorEntry.getValue();
            if (factor > maxFactor) {
                maxFactor = factor;
            }
        }

        long sub = 1;
        long greatesFactorCount = factors.get(maxFactor);
        for (int i = 0; i < greatesFactorCount; ++i) {
            if ((sub * maxFactor) < N) {
                sub *= maxFactor;
            }
        }

        for (var factorEntry : factors.entrySet()) {
            var factor = factorEntry.getKey();
            var count = factorEntry.getValue();
            if (count > 1) {
                if (factor != maxFactor) {
                    sub *= Math.pow(factor, count - 1);
                }
            }
        }

        return N - sub;
    }

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

    private static HashMap<Long, Integer> primeFactors(long number) {
        HashMap<Long, Integer> factors = new HashMap<Long, Integer>();

        long factor = 2;
        while (number > 1) {
            if (number % factor == 0) {
                number /= factor;

                if (factors.containsKey(factor)) {
                    int count = factors.get(factor);
                    factors.put(factor, count + 1);
                } else {
                    factors.put(factor, 1);
                }
            } else {
                ++factor;
            }
        }
        return factors;
    }

}
