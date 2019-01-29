package ejerciciospracticas3;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    public static void main(String[] args) {
        int[] A = new int[3];
        A[0] = 1;
        A[1] = 4;
        A[2] = -3;
        int[] B = new int[5];
        B[0] = -8;
        B[1] = 4;
        B[2] = 5;
        B[3] = -10;
        B[4] = 3;
        System.out.println(solution3(B));
    }
    public static int solution3(int []A){
        int suma=0;
        int k=0;
        int sumaMenor=Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            
            for (int j = k; j < A.length; j++) {
                suma=Math.abs(A[i]+A[j]);
                if(suma<sumaMenor){
                    sumaMenor=suma;
                }
            }
            k++;
        }
        return sumaMenor;
    }
    public static int solution(int[] A) {
        int N = A.length;
        Arrays.sort(A);
        int tail = 0;
        int head = N - 1;
        int minAbsSum = Math.abs(A[tail] + A[head]);
        while (tail <= head) {
            int currentSum = A[tail] + A[head];
            minAbsSum = Math.min(minAbsSum, Math.abs(currentSum));
            // If the sum has become
            // positive, we should know that the head can be moved left
            if (currentSum <= 0) {
                tail++;
            } else {
                head--;
            }
        }
        return minAbsSum;
    }

    public static int solution1(int[] A) {
        Arrays.sort(A);
        int start = 0;
        int end = A.length - 1;
        int result = Math.abs(A[0] * 2);
        while (start < end) {
            int cur = Math.min(Math.abs(A[start] + A[end]), Math.min(Math.abs(A[start] * 2), Math.abs(A[end] * 2)));
            if (cur == 0) {
                return 0;
            }
            result = Math.min(result, cur);
            if (A[start] >= 0 || A[end] <= 0) {
                break;
            }
            if (start + 1 < end) {
                if (Math.abs(A[start + 1] + A[end]) < Math.abs(A[start] + A[end - 1])) {
                    start++;
                } else {
                    end--;
                }
            } else {
                break;
            }
        }
        return result;
    }
}
