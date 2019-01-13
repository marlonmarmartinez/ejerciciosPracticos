
package ejerciciospracticas;

public class MissingInteger {
    
    public static void main(String[] args) {
        MissingInteger m=new MissingInteger();
        int []A = {1, 3, 6, 4, 1, 2};
        System.out.println(m.solution(A));
    }
     public int solution(int[] A) {
    
        boolean[] B = new boolean[A.length];
        int i =0;
        for(i=0; i<A.length;i++){
            if((A[i]>0) && (A[i]<=A.length) && (B[A[i]-1] == false))
                B[A[i]-1] = true;
        }
        for(i=0; i< B.length;i++){
            if(B[i]==false)
                return i+1;
        }
        if(i==B.length)
            return i+1;
        else
            return 1;
    }
   
}
