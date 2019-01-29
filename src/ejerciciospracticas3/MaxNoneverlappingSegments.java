package ejerciciospracticas3;

public class MaxNoneverlappingSegments {

    public static void main(String[] args) {
        int []A=new int[5];
        int []B=new int[5];
        A[0] = 1;
        B[0] = 5;
        A[1] = 3;
        B[1] = 6;
        A[2] = 7;
        B[2] = 8;
        A[3] = 9;
        B[3] = 9;
        A[4] = 9;
        B[4] = 10;
        System.out.println(solution1(A, B));
    }

    public static int solution(int A[], int B[]) {
        int N = A.length;
        if (N <= 1) {
            return N;
        }

        int cnt = 1;
        int prev_end = B[0];

        int curr;
        for (curr = 1; curr < N; curr++) {
            if (A[curr] > prev_end) {
                cnt++;
                prev_end = B[curr];
            }
        }

        return cnt;
    }
    public static int solution1(int[] A, int[] B) {
        int ans = 0, pre = -1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > pre) {
                ans++;
                pre = B[i];
            }
        }
        return ans;
    }
}
