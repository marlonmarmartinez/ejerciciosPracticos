
package ejerciciospracticas;


public class PassingCars {
    public static void main(String[] args) {
        PassingCars p=new PassingCars();
        int []A=new int[5];
        A [0] = 0;
        A [1] = 1 ;
        A [2] = 0 ;
        A [3] = 1 ;
        A [4] = 1;
        System.out.println(p.solution(A));
    }
  
public int solution(int[] A) {
    int total = 0;
    int unoCounter = 0;
    for (int i = 0; i<A.length; i++) {
        if (A[i] != 1) {
            unoCounter++;
        } else {
            total += unoCounter;
            if (total > 1000000000) {
                return -1;
            }
        }
    }
    return total;
}
  
}
