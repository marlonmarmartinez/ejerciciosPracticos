
package ejerciciospracticas;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {
        PermCheck p=new PermCheck();
        int [] A=new int [4];
            A [0] = 4;
            A [1] = 1;
            A [2] = 3;
            A [3] = 2;
            System.out.println(p.solution1(A));
    }
    public static int solution(int[] A) {
        int[] counter = new int [A.length];
        for(int i= 0; i< A.length; i++){
            if (A[i] < 1 || A[i] > A.length) {
                // Out of range
                return 0;
            }
            else if(counter[A[i]-1] == 1) {
                // met before
                return 0;
            }
            else {
                // first time meet
                counter[A[i]-1] = 1;
            }
        }
        return 1;
    }
    

public int solution1(int[] A) {
    Arrays.sort(A);
    for (int i = 0; i < A.length; i++) {
        if (A[i] != i + 1)
            return 0;
    }
    return 1;
}
}
