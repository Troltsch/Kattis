package Kattis.jackpot;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

class jackpot {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

    public static BigInteger leastCommonMultiple(ArrayList<Long> numbers) {
        HashMap<Long, Integer> primeFactors = new HashMap<>();

        for (long number : numbers) {
            var factors = primeFactors(number);
            for (var entry : factors.entrySet()) {
                long factor = entry.getKey();
                int count = entry.getValue();
                if (!primeFactors.containsKey(factor)) {
                    primeFactors.put(factor, count);
                } else {
                    long currentCount = primeFactors.get(factor);
                    primeFactors.put(factor, (int) Math.max(count, currentCount));
                }
            }
        }

        BigInteger lcm = BigInteger.ONE;
        for (var entry : primeFactors.entrySet()) {
            long factor = entry.getKey();
            int count = entry.getValue();
            lcm = lcm.multiply(BigInteger.valueOf((long) Math.pow(factor, count)));
            if (lcm.compareTo(BigInteger.valueOf(1000000000)) != 1) {
                continue;
            }

            return BigInteger.valueOf(1000000001);
        }

        return lcm;
    }

    public static void main(String[] args) throws IOException {

        for (int i = 2; i < 65555; ++i) {
            if (isPrime(i))
                primes.add((long) i);
        }

        int n = Integer.parseInt(br.readLine());
        while (--n >= 0) {
            int w = Integer.parseInt(br.readLine()); // Ignore
            String[] lineTokens = br.readLine().split(" ");
            var numbers = new ArrayList<Long>();
            for (int i = 0; i < w; ++i) {
                var val = Long.parseLong(lineTokens[i]);
                numbers.add(val);
                if (isPrime(val))
                    primes.add(val);
            }

            var LCM = leastCommonMultiple(numbers);

            if (LCM.compareTo(BigInteger.valueOf(1000000000)) != 1) {
                bw.write(LCM + "\n");
            } else {
                bw.write("More than a billion.\n");
            }

        }
        bw.flush();
    }
}
