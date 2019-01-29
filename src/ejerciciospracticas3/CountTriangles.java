package ejerciciospracticas3;

import java.util.Arrays;

public class CountTriangles {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{10, 2, 5, 1, 8, 12}));
    }

    public static int solution(int[] A) {

        final int N = A.length;

        if (N == 0) {
            return 0;
        }

        Arrays.sort(A);

        int triangulos = 0;
        for (int i = 0; i < N - 2; i++) {
            int end = i + 2;
            for (int j = i + 1; j < N - 1; j++) {
                while (end < N && A[i] + A[j] > A[end]) {
                    end++;
                }
                triangulos += end - j - 1;
            }
        }
        return triangulos;
    }

}
