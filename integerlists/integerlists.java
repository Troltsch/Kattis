package Kattis.integerlists;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class integerlists {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static boolean checkDropCommands(String p, int n) throws IOException {
        int dCommands = 0;
        for (int i = 0; i < p.length(); ++i) {
            if (p.charAt(i) == 'D')
                ++dCommands;
        }

        if (dCommands > n) {
            bw.write("error\n");
            return false;
        } else if (dCommands == n) {
            bw.write("[]\n");
            return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        int cases = Integer.parseInt(br.readLine());
        while (--cases >= 0) {
            var p = br.readLine();
            var n = Integer.parseInt(br.readLine());
            var input = br.readLine();

            if (!checkDropCommands(p, n)) {

                continue;
            }

            input = input.substring(1, input.length() - 1);

            var integers = input.split(",");
            var array = new ArrayList<Integer>(integers.length);
            for (var val : integers) {
                array.add(Integer.parseInt(val));
            }

            int leftPos = 0;
            int rightPos = array.size() - 1;
            boolean isLeft = true;
            for (int i = 0; i < p.length(); ++i) {
                char command = p.charAt(i);
                if (command == 'R')
                    isLeft = !isLeft;
                else {
                    if (isLeft)
                        ++leftPos;
                    else
                        --rightPos;
                }
            }

            // print from left to right
            bw.write("[");
            if (isLeft) {
                bw.write("" + array.get(leftPos));
                for (int i = leftPos + 1; i <= rightPos; ++i) {
                    bw.write("," + array.get(i));
                }
            } else // print from right to left
            {
                bw.write("" + array.get(rightPos));
                for (int i = rightPos - 1; i >= leftPos; --i) {
                    bw.write("," + array.get(i));
                }
            }

            bw.write("]\n");
        }

        bw.flush();
    }
}
