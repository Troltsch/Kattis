package Kattis.thinkingofanumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class thinkingofanumber {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int MAX_VALUE = 50001;
  static int MIN_VALUE = 0;

  public static void main(String args[]) throws IOException {
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0)
        break;

      boolean haveLessThan = false;
      int lessThan = MAX_VALUE;
      int greaterThan = MIN_VALUE;
      var divisors = new ArrayList<Integer>();
      for (int i = 0; i < n; ++i) {
        String[] lineTokens = br.readLine().split(" ");
        int value = Integer.parseInt(lineTokens[2]);
        if (lineTokens[0].charAt(0) == 'l') // less
        {
          haveLessThan = true;
          if (value < lessThan)
            lessThan = value;
        } else if (lineTokens[0].charAt(0) == 'g') // greater
        {
          if (value > greaterThan)
            greaterThan = value;
        } else // divisible
        {
          divisors.add(value);
        }
      }

      if (!haveLessThan) {
        bw.write("infinite\n");
        continue;
      }

      var results = new ArrayList<Integer>();

      for (int i = greaterThan + 1; i < lessThan; ++i) {
        boolean valid = true;
        int value = i;

        for (var number : divisors) {
          if (value % number != 0) {
            valid = false;
            break;
          }
        }

        if (valid) {
          results.add(value);
        }
      }

      if (results.size() == 0) {
        bw.write("none\n");
      } else {
        for (int i = 0; i < results.size() - 1; ++i) {
          bw.write(results.get(i) + " ");
        }
        bw.write(results.get(results.size() - 1) + "\n");
      }
    }
    bw.flush();
  }
}

/*
 * 3
 * less than 100
 * divisible by 3
 * divisible by 7
 * 3
 * greater than 6
 * less than 9
 * divisible by 3
 * 3
 * divisible by 1
 * greater than 6
 * greater than 500
 * 1
 * less than 2
 * 0
 */