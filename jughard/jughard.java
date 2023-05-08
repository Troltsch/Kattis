package Kattis.jughard;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

class jughard {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean check(int a, int b, int d) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        if (min == 1)
            return true;

        if ((d == min) || (d == max)) {
            return true;
        }

        if ((max - min) <= d) {
            int val = BigInteger.valueOf(max).gcd(BigInteger.valueOf(min)).intValue();
            if (d % val == 0)
                return true;
        }

        return false;
    }

    private static void algo(int a, int b, int d) throws IOException {
        boolean res = check(a, b, d);

        if (res) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (--T >= 0) {
            String[] lineTokens = br.readLine().split(" ");
            int a = Integer.parseInt(lineTokens[0]);
            int b = Integer.parseInt(lineTokens[1]);
            int d = Integer.parseInt(lineTokens[2]);

            algo(a, b, d);
        }
        bw.flush();
    }
}
