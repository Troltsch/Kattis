package Kattis.fundamentalneighbors;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class fundamentalneighbors {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> primes = new ArrayList<Integer>();

    public static void main(String args[]) throws IOException {
        for (int i = 2; i <= 66000; ++i) {
            if (isPrime(i))
                primes.add(i);
        }

        String input;
        while ((input = br.readLine()) != null) {
            long n = Long.parseLong(input);
            if (isPrime(n)) {
                bw.write(n + " " + 1 + "\n");
                continue;
            }

            var neighborSum = primeFactorNeighborSum(n);

            bw.write(n + " " + neighborSum + "\n");
            // bw.flush();
        }
        bw.flush();
    }

    private static boolean isPrime(long n) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    private static long primeFactorNeighborSum(long number) {

        long count = 0;
        long result = 1;
        int index = 0;
        while (number > 1) {
            if (primes.size() == index) {
                break;
            }
            int factor = primes.get(index);
            if (number % factor == 0) {
                number /= factor;
                ++count;
            } else {
                if (count > 0) {
                    result *= Math.pow(count, factor);
                    count = 0;
                }

                ++index;
            }
        }
        if (count > 0) {
            result *= Math.pow(count, primes.get(index));
        }

        return result;
    }

}
