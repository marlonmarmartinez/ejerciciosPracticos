
package ejerciciospracticas;


public class MinAvgTwoSlice {
    
    public static void main(String[] args) {
        MinAvgTwoSlice m=new MinAvgTwoSlice();
        int []A=new int[7];
        A [0] = 4;
        A [1] = 2;
        A [2] = 2;
        A [3] = 5;
        A [4] = 1;
        A [5] = 5;
        A [6] = 8;
        System.out.println(m.solution(A));
    }
     public int solution(int[] A) {
        int[] sum = new int[A.length + 1];
        // We store the prefix sums here, please note prefix sum arrays start with 0 so their size is A.length + 1;
        sum[0] = 0;
        for (int i = 0; i < A.length; i++) {
            sum[i + 1] = sum[i] + A[i];
        }
        int result = 0;
        double best = 10000;
        for (int i = 0; i < A.length - 2; i++) {
            // Try pair
            double average = 1.0d * (sum[i + 2] - sum[i]) / 2;
            if (average < best) {
                best = average;
                result = i;
            }
            // Try triade
            average = 1.0d * (sum[i + 3] - sum[i]) / 3;
            if (average < best) {
                best = average;
                result = i;
            }
        }
        // Last pair
        double average = 1.0d * (sum[A.length] - sum[A.length - 2]) / 2;
        if (average < best) {
            result = A.length - 2;
        }
        return result;
    }
}
