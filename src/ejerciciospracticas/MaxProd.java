
package ejerciciospracticas;

import java.util.Arrays;


public class MaxProd {
    
    public static void main(String[] args) {
        MaxProd m=new MaxProd();
        int []A=new int[6];
        A [0] = -3;
        A [1] = 1;
        A [2] = 2;
        A [3] = -2;
        A [4] = 5;
        A [5] = 6;
        System.out.println(m.solution(A));
    }

    public int solution(int[] A) {
         if(A == null || A.length < 3) {
            return 0;
         }
            Arrays.sort(A);
            int lastIndex = A.length - 1;
            int bigestElements = A[lastIndex] * A[lastIndex - 1] * A[lastIndex - 2];
            int twoBigestNegs = A[0] * A[1] * A[lastIndex];
            int maxProduct = Math.max(bigestElements, twoBigestNegs);
            return maxProduct;
    }
   
    public int solution1(int[] A) {
        int retval1 = 0;
        int retval2 = 0;
        Arrays.sort(A);
        if (A[0] < 0 && A[1] < 0) {
            retval1 = Math.abs(A[0]);
            retval1 *= Math.abs(A[1]);
            retval1 *= A[A.length-1];
        }
        retval2 = A[A.length-3];
        retval2 *= A[A.length-2];
        retval2 *= A[A.length-1];
        return Math.max(retval1, retval2);
    }
}
