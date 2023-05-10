package Kattis.airconditioned;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class airconditioned {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String args[]) throws IOException {
        var N = Integer.parseInt(br.readLine());
        List<Minion> minions = new ArrayList<Minion>();

        var minTemp = N * 2;
        var maxTemp = 0;
        for (int i = 0; i < N; i++) {
            var token = br.readLine().split(" ");
            int L = Integer.parseInt(token[0]);
            int U = Integer.parseInt(token[1]);
            minions.add(new Minion(L, U));

            minTemp = Math.min(minTemp, L);
            maxTemp = Math.max(maxTemp, U);
        }

        Collections.sort(minions);

        int currentMinion = 0;
        int groups = 0;
        for (int i = minTemp; i <= maxTemp; ++i) {
            int currentTemp = i;
            for (int j = currentMinion; j < minions.size(); ++j) {
                var minion = minions.get(j);
                if (minion.L > currentTemp)
                    break;

                if (minion.U == currentTemp) {
                    ++groups;
                    // System.out.println("Group up for: " + currentMinion + " @ " + currentTemp);
                    for (int k = currentMinion; k < minions.size(); ++k) {
                        var minion2 = minions.get(k);
                        if (currentTemp < minion2.L || currentTemp > minion2.U) {
                            currentMinion = k;
                            // System.out.println("Stop grouping to " + k);
                            break;
                        }

                        if (k == minions.size() - 1) {
                            System.out.println(groups);
                            System.exit(0);
                        }
                    }
                    break;
                }
            }
        }

    }

    static class Minion implements Comparable<Minion> {
        int L;
        int U;

        Minion() {
        }

        Minion(int L, int U) {
            this.L = L;
            this.U = U;
        }

        @Override
        public int compareTo(Minion arg0) {
            if (this.L == arg0.L)
                return Integer.compare(this.U, arg0.U);
            return Integer.compare(this.L, arg0.L);
        }
    }

}
