
package ejerciciospracticas;

import java.util.Arrays;


public class CyclicRotation {
    
    public static void main(String[] args) {
        CyclicRotation c=new CyclicRotation();
       int[] A = {3, 8, 9, 7, 6};
       int k=3;
        System.out.println(Arrays.toString(c.solution(A, k)));
    }
    public int[] solution(int[] A, int K) {
        int size = A.length;
        int[] cyclic = new int [size];
        for (int x=0; x<size; x++) {
            cyclic[(x + K) % size] = A[x]; 
        }

    return cyclic;
       /*int size = A.length;
            int[] cyclic = new int[size];
            K %= size;
            for (int i=0; i<size-K; ++i) 
            {
                cyclic[K + i] = A[i]; 
            }

            for (int i=0; i<K; ++i)
            {
                cyclic[i] = A[size - K + i]; 
            }
        return cyclic;
            int[] shiftedArray = new int[A.length];
        for (int i = 0; i < A.length; i++) {
        if (i + K >= A.length)
            shiftedArray[(i + K) % A.length] = A[i];
        else
            shiftedArray[i + K] = A[i];
    }
    return shiftedArray;
    */
}
}


