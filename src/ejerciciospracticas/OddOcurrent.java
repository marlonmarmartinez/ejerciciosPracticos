
package ejerciciospracticas;

import java.util.Arrays;


public class OddOcurrent {
    
    public static void main(String[] args) {
        OddOcurrent o=new OddOcurrent();
        int []A=new int [7];
        A [0] = 9; A [1] = 3; A [2] = 9;
        A [3] = 3; A [4] = 9; A [5] = 7;
        A [6] = 9; 
        
        System.out.println(o.solution(A));
    }
    

public int solution(int[] A) {
        /*Arrays.sort(A);
        int i;
        for (i=0; i<A.length-1 && A[i] == A[i+1]; i+=2);
        return A[i];*/
       /* Arrays.sort(A);
    int i, j, count = 0;
    for (i = 0; i < A.length; i++) {
        for (j = i + 1; j < A.length; j++) {
            if (A[i] == A[j])
                count++;
            else
                break;
            }
        if (count % 2 == 0)
            return A[i];
        else {
            count = 0;
            i = j - 1;
        }
    }
    return 0;*/
       int elem = 0;

		for (int i = 0; i < A.length; i++) {
			elem ^= A[i];
		}
		return elem;
    
}
}
