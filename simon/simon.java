package Kattis.simon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class simon {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        long N = Long.parseLong(br.readLine());
        for (int i = 0; i < N; ++i) {
            String input = br.readLine();
            if (input.startsWith("simon says ") && input.length() > 11) {
                bw.write(input.substring(11) + '\n');
            } else {
                bw.write("\n");
            }
        }
        bw.flush();
    }
}
