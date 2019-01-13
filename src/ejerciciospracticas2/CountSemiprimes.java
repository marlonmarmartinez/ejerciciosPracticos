package ejerciciospracticas2;

import java.util.ArrayList;
import java.util.Arrays;

public class CountSemiprimes {

    public static void main(String[] args) {
        CountSemiprimes c = new CountSemiprimes();
        int N = 26;
        int[] P = new int[3];
        int[] Q = new int[3];
        P[0] = 1;
        Q[0] = 26;
        P[1] = 4;
        Q[1] = 10;
        P[2] = 16;
        Q[2] = 20;
        System.out.println(Arrays.toString(c.solution(N, P, Q)));
    }

    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        ArrayList<Integer> semiprimes = new ArrayList<>();
        int[] results = new int[P.length];

        if (N < 4) {

        } else {
            for (int i = 2; i <= N; i++) {
                int semiprimesCount = 0;
                for (int j = 1; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        semiprimesCount++;
                    }
                }
                if (semiprimesCount == 2) {
                    boolean isSecond = true;
                    for (int k = 0; k < semiprimes.size(); k++) {
                        if (i % semiprimes.get(k) == 0) {
                            isSecond = false;
                            break;
                        }
                    }
                    if (isSecond) {
                        // System.out.println("Semiprimes "+ i);
                        semiprimes.add(i);
                    }
                }
            }
            int[] preSum = new int[N + 1];
            int semiprimesIndex = 0;
            for (int i = 0; i < N + 1; i++) {
                if (semiprimesIndex < semiprimes.size()) {
                    if (semiprimes.get(semiprimesIndex) == i) {
                        // System.out.println("Semiprimes "+ semiprimes.get(semiprimesIndex));
                        preSum[i] = 1;
                        semiprimesIndex++;
                    }
                }

                if (i > 0) {
                    preSum[i] = preSum[i] + preSum[i - 1];
                }
                // System.out.println("Index "+i+":"+ preSum[i]);
            }

            for (int i = 0; i < P.length; i++) {
                results[i] = preSum[Q[i]] - preSum[P[i] - 1];
            }

        }

        return results;
    }
}
