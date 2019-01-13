/*
 Se proporciona una matriz A no vacía que consta de N enteros. Un par de enteros (P, Q), de manera que 0 ≤ P ≤ Q <N, se denomina segmento de matriz A. La suma de un segmento (P, Q) es el total de A [P] + A [P +1] + ... + A [Q].
 */
package ejerciciospracticas2;

public class MaxSliceSum {
    
    public static void main(String[] args) {
        MaxSliceSum m=new MaxSliceSum();
        int A[]=new int[5];
        A [0] = 3 ;A [1] = 2 ;A [2] = -6;
        A [3] = 4 ;A [4] = 0;
        System.out.println(m.solution1(A));
    }
    public int solution(int[] A) {
        
        // initial setting A[0]
        int maxEndingPrevious = A[0];
        int maxEndingHere = A[0];
        int maxSoFar = A[0];
 
        // note: for i=0, it will return A[0] (also for "one element" cases)  
           
        for(int i = 1; i < A.length; i++){
            maxEndingHere = Math.max(A[i], maxEndingPrevious + A[i]); // <--- key point~!!
            maxEndingPrevious = maxEndingHere;
            maxSoFar = Math.max(maxSoFar, maxEndingHere); // update the max (be careful)
        }
        
        return maxSoFar; // can be used for "all negative" cases 
    }
     public int solution1(int[] A) {
        // write your code in Java SE 8
        
        int max_ending = A[0];
        int max_slice = A[0];
        
        for (int i=1; i<A.length; i++) {
            if (max_ending<0) {
                max_ending = A[i];
            }
            else {
                max_ending = max_ending + A[i];
            }
            if (max_ending>max_slice) {
                max_slice = max_ending;
            }
        }
        
        return max_slice;
        
    }
}
