package Kattis.joinstrings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class joinstrings {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<String> strings = new ArrayList<String>();
    static ArrayList<ArrayList<Integer>> numberStrings = new ArrayList<ArrayList<Integer>>();

    public static void rec(int parent) throws IOException {
        bw.write(strings.get(parent));
        for (var child : numberStrings.get(parent)) {
            rec(child);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; ++i) {
            strings.add(br.readLine());
            var list = new ArrayList<Integer>();
            numberStrings.add(list);
        }

        int a = 0;
        int b = 0;
        for (int i = 0; i < N - 1; ++i) {
            String[] tokens = br.readLine().split(" ");
            a = Integer.parseInt(tokens[0]) - 1;
            b = Integer.parseInt(tokens[1]) - 1;

            numberStrings.get(a).add(b);
        }

        rec(a);

        bw.write('\n');
        bw.flush();
    }
}
