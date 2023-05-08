package Kattis.primereduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.HashMap;

public class primereduction {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static HashMap<Long, Boolean> primeMap = new HashMap<Long, Boolean>();

    public static void main(String args[]) throws IOException {
        primeMap.put(1l, false);
        while (true) {
            long x = Long.parseLong(br.readLine());
            if (x == 4)
                break;

            int iteration = 1;
            while (true) {
                if (isPrime(x)) {
                    bw.write(x + " " + iteration + "\n");
                    break;
                }
                ++iteration;
                x = sumPrimeFactors(x);
            }
        }
        bw.flush();
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

    static long sumPrimeFactors(long num) {
        long sum = 0;
        for (long i = 2; i <= num; i++) {
            while (num % i == 0) {
                sum += i;
                num /= i;
            }
        }
        return sum;
    }
}
