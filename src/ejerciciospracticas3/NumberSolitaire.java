package ejerciciospracticas3;

import java.util.Random;

public class NumberSolitaire {

    public static void main(String[] args) {
        int[] A = new int[6];
        A[0] = 1;
        A[1] = -2;
        A[2] = 0;
        A[3] = 9;
        A[4] = -1;
        A[5] = -2;
        System.out.println(solution1(A));
    }

    public static int solution(int[] A) {
        int suma = A[0];
        Random rn = new Random();
        int res;
        int pos=0;
        //int i=0;
//            for (int i = pos; i < A.length; i++) {
            while(pos!=A.length-1){
                 res = rn.nextInt(6-pos) + 1;
                 
                if (res < A.length && pos+res<A.length) {
                    
                   pos += res;
                   suma += A[pos];
                }
                if(pos==A.length-1){
                    return suma;
                }
               //i=pos;
            }
        

        return suma;
    }
    public static int solution1(int[] A) {

        int[] dp = new int[A.length];
        dp[0] = A[0];

        for(int i=1; i<A.length; i++){
           
            int max = Integer.MIN_VALUE;
            
            for(int die=1; die<=6; die++){
                if( i-die >= 0){
                    
                    max = Math.max( dp[i-die]+A[i], max );
                   
                }
            }    
            dp[i] = max;     
        }
        
        return dp[A.length-1];
    }
}
