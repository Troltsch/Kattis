package Kattis.smallestmultiple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

public class smallestmultiple {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] numberStrings = line.split(" ");
            ArrayList<Long> numbers = new ArrayList<Long>();
            for (String number : numberStrings) {
                numbers.add(Long.parseLong(number));
            }
            BigInteger LCM = leastCommonMultiple(numbers);
            System.out.println(LCM);
        }
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
        }

        return lcm;
    }

    public static HashMap<Long, Integer> primeFactors(long number) {
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