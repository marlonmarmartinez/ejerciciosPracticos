package ejerciciospracticas3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class AbsDistinct {

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = -5;
        A[1] = -3;
        A[2] = -1;
        A[3] = 0;
        A[4] = 3;
        A[5] = 6;
        System.out.println(solution(A));
    }
    public static int solution(int[]A){
        
      //  int con=0;
        //int valorabs=A.length;
        int []B=new int [A.length];
        Set aSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            B[i]=Math.abs(A[i]);
            aSet.add(B[i]);
           /* for (int j = 0; j < A.length; j++) {
                
                if(i != j){
                    if(Math.abs(A[i])==Math.abs(A[j])){
                        con++;
                       
                    }
                }
            }*/
        }
        
        return aSet.size();
    }
    public int solution1(int[] A) {
        return (int)Arrays.stream(A).map(a -> a<0?-a:a).distinct().count();
    }
    
     public int solution2(int[] A) {
        int newLength = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i]!=A[newLength]) {
                A[++newLength] = A[i];
            }
        }
        int ans = ++newLength;
        int left = 0, right = 0;
        while (left < newLength && A[left] < 0) left++;
        right = left;
        left--;
        while (left >= 0 && right < newLength) {
            if (A[left] + A[right] == 0) {
                ans--;
                left--;
                right++;
            } else if (A[left] + A[right] > 0) {
                left--;
            } else right++;
        }
        return ans;
    }
}
