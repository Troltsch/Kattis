package Kattis.olderbrother;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class olderbrother {
    // static Scanner sc = new Scanner(System.in);
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Long> primes = new ArrayList<Long>();

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

    public static void main(String args[]) throws IOException {
        for (int i = 2; i < 65555; ++i) {
            if (isPrime(i))
                primes.add((long) i);
        }

        Long q = Long.parseLong(br.readLine());
        var factors = primeFactors(q);
        if (isPrime(q) || factors.size() == 1) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}