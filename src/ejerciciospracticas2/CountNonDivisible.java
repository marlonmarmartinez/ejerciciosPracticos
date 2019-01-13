package ejerciciospracticas2;

import java.util.Arrays;

public class CountNonDivisible {

    public static void main(String[] args) {
        CountNonDivisible c = new CountNonDivisible();
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 1;
        A[2] = 2;
        A[3] = 3;
        A[4] = 6;
        System.out.println(Arrays.toString(c.solution(A)));
    }

    public int[] solution(int[] A) {
        int[][] D = new int[A.length * 2 + 1][2];

        for (int i = 0; i < A.length; i++) {
            D[A[i]][0]++;
            D[A[i]][1] = -1;
        }

        for (int i = 0; i < A.length; i++) {
            if (D[A[i]][1] == -1) {
                D[A[i]][1] = 0;
                for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                    if (A[i] % j == 0 && A[i] / j != j) {
                        D[A[i]][1] += D[j][0];
                        D[A[i]][1] += D[A[i] / j][0];
                    } else if (A[i] % j == 0 && A[i] / j == j) {
                        D[A[i]][1] += D[j][0];
                    }
                }
            }
        }
        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - D[A[i]][1];
        }
        return A;
    }
}
