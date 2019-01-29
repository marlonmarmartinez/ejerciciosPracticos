
package ejerciciospracticas3;


public class MinMaxDivision {
    
    public static void main(String[] args) {
        int k=3; int m=5;
        int[]A=new int [7];
        A[0] = 2;
        A[1] = 1;
        A[2] = 5;
        A[3] = 1;
        A[4] = 2;
        A[5] = 2;
        A[6] = 2;
        System.out.println(solution(k, m, A));
    }
    public static int solution(int K, int M, int[] A) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {//get the sum as max, and the largest number as min
            max += A[i];
            min = Math.max(min, A[i]);
        }
        int result = max;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (divisionSolvable(mid, K - 1, A)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }
    private static boolean divisionSolvable(int mid, int k, int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                sum = a[i];
                k--;
            }
            if (k < 0) {
                return false;
            }
        }
        return true;
    }
    
    public static int solution1(int K, int M, int[] A) {
        int lower = max(A);
        int upper = sum(A);
        while(true){
            int mid = (lower+upper)/2;
            int blocks = calculateBlockCount(A, mid);
            if(blocks < K){
                upper = mid-1;
            }else if(blocks > K){
                lower = mid+1;
            }else{
                return upper;
            }
        }
    }
    private static int calculateBlockCount(int[] a, int maxSum) {
        int count = 0;
        int sum = a[0];
        for(int i=1; i<a.length; i++){
            if(sum + a[i] > maxSum){
                count++;
                sum = a[i];
            }else{
                sum += a[i];
            }
        }
        return count;
    }
    private static int sum(int[] a) { int sum = 0; for(int i:a){ sum+=i; } return sum; }
    private static int max(int[] a) { int max = -1; for(int i:a){ if(i > max){ max = i; } } return max; }
}
