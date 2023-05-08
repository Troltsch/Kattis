package Kattis.icons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class icons {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        BigInteger rowLen1 = BigInteger.ZERO;
        long maxHeight = 0;
        for (int i = 0; i < N; ++i) {
            var val = Long.parseLong(br.readLine());
            if (val > maxHeight)
                maxHeight = val;

            rowLen1 = rowLen1.add(BigInteger.valueOf(val));
        }
        var firstValSecondRow = Long.parseLong(br.readLine());
        BigInteger rowLen2 = BigInteger.ZERO;
        for (int i = 1; i < N; ++i) {
            var val = Long.parseLong(br.readLine());
            if (val > maxHeight)
                maxHeight = val;

            rowLen2 = rowLen2.add(BigInteger.valueOf(val));
        }

        if (rowLen1.compareTo(rowLen2) == 1)
            rowLen2 = rowLen1;

        BigInteger area = rowLen1.multiply(BigInteger.valueOf(maxHeight + firstValSecondRow));
        System.out.println(area);
    }
}
