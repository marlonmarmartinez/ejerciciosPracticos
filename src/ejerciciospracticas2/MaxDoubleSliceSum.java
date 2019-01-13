package ejerciciospracticas2;

public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        MaxDoubleSliceSum m = new MaxDoubleSliceSum();
        int[] A = new int[8];
        A[0] = 3;
        A[1] = 2;
        A[2] = 6;
        A[3] = -1;
        A[4] = 4;
        A[5] = 5;
        A[6] = -1;
        A[7] = 2;
        
        System.out.println(m.solution(A));
    }

    public int solution(int[] A) {
        int N = A.length;
        int[] K1 = new int[N];
        int[] K2 = new int[N];

        for (int i = 1; i < N - 1; i++) {
            K1[i] = Math.max(K1[i - 1] + A[i], 0);
        }
        for (int i = N - 2; i > 0; i--) {
            K2[i] = Math.max(K2[i + 1] + A[i], 0);
        }

        int max = 0;

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, K1[i - 1] + K2[i + 1]);
        }

        return max;
    }
}
