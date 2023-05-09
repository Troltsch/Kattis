package Kattis.oddecho;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class oddecho {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; ++i) {
            String s = br.readLine();
            if (i % 2 == 1) {
                bw.write(s + '\n');
            }
        }

        bw.flush();
    }
}
