
package ejerciciospracticas;


public class FrogRiver {

    public static void main(String[] args) {
        FrogRiver f=new FrogRiver();
        int [] A=new int[8];
        int x=5;
        A [0] = 1;
        A [1] = 3;
        A [2] = 1;
        A [3] = 4;
        A [4] = 2;
        A [5] = 3;
        A [6] = 5;
        A [7] = 4;
        System.out.println(f.solution2(x, A));
    }
     public int solution(int[] A) {
        // write your code in Java SE 8
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
     
  public int solution1(int X, int[] A) {
            int sumToX = (X*(X+1)/2);
            int currentSum = 0;
            boolean[] seen = new boolean[X+1];
            int index = 0;
            for(int i : A) {
                if(!seen[i-1]) {
                    seen[i-1] = true;
                    currentSum+=i;
                }
                if(currentSum == sumToX) {
                    return index;
                }
                index++;
            }
            return -1;
        }
  public int solution2(int X, int[] A) {
        int steps = X;
        boolean[] bitmap = new boolean[steps+1];
        for(int i = 0; i < A.length; i++){
            if(!bitmap[A[i]]){
                bitmap[A[i]] = true;
                steps--;
            }
            if(steps == 0) return i;
        }
        return -1;
    }
}
