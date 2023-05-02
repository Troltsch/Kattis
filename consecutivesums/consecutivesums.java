package Kattis.consecutivesums;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class consecutivesums {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) throws IOException {
        int T = sc.nextInt();

        while (--T >= 0) {
            int N = sc.nextInt();

            // Is power of 2?
            if (isPowerOfTwo(N) || (N == 1) || (N == 2)) {
                System.out.println("IMPOSSIBLE");
                continue;
            }

            // Is odd?
            if (isOdd(N)) {
                int first = (int) (N / 2);
                int second = (int) (N / 2 + 1);
                System.out.println(N + " = " + first + " + " + second);
                continue;
            }

            int currentValue = 3;
            int substract = 6;
            while (true) {
                int checkValue = N - substract;
                if (checkValue % currentValue == 0) {
                    int firstValue = ((int) (N / currentValue)) - ((int) (currentValue / 2));
                    if (!isOdd(currentValue)) {
                        firstValue += 1;
                    }

                    System.out.print(N + " =");
                    for (int i = 0; i < currentValue; ++i) {
                        if (i == 0) {
                            System.out.print(" " + firstValue);
                        } else {
                            System.out.print(" + " + (firstValue + i));
                        }
                    }
                    System.out.println();
                    break;
                }
                ++currentValue;
                substract += currentValue;
            }
        }
    }

    public static boolean isOdd(int value) {
        return value % 2 == 1;
    }

    public static boolean isPowerOfTwo(int value) {
        return (value > 0) && ((value & (value - 1)) == 0);
    }
}
