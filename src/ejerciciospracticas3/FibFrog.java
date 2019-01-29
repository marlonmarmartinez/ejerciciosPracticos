
package ejerciciospracticas3;


public class FibFrog {
    
    public static void main(String[] args) {
        int n=11;
        int [] A=new int[n];
        A[0] = 0;
        A[1] = 0;
        A[2] = 0;
        A[3] = 1;
        A[4] = 1;
        A[5] = 0;
        A[6] = 1;
        A[7] = 0;
        A[8] = 0;
        A[9] = 0;
        A[10] = 0;
        
        System.out.println(solution1(A));
    }
    
    public static int solution1(int[] A) {
        if (A.length == 0) {
            return 1;
        }
        int[] dp = new int[A.length + 2];
        dp[0] = 1;
        dp[A.length + 1] = -1;
        for (int i = 1; i < A.length + 2; i++) {
            int step = 1;
            int previous = 1;
            int min = Integer.MAX_VALUE;
            while (step <= i) {
                // System.out.format("step: %d\n", step);
                if ((i == A.length + 1 || A[i - 1] == 1) && (i - step - 1 == -1 || A[i - step - 1] == 1) && dp[i - step] > 0) {
                    min = Math.min(min, dp[i - step] + 1);
                    // System.out.format("new min: %d\n", min);
                }
                int tmp = step;
                step = step + previous;
                previous = tmp;
            }
            if (min < Integer.MAX_VALUE) {
                dp[i] = min;
            }
            // System.out.format("i: %d, dp: %s\n", i, java.util.Arrays.toString(dp));
        }
        // System.out.format("dp: %s\n", java.util.Arrays.toString(dp));
        return dp[A.length + 1] == -1 ? -1 : dp[A.length + 1] - 1;
    }
}
