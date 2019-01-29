package ejerciciospracticas3;

public class TieRopes {

    public static void main(String[] args) {
        int[] A = new int[7];
        int k=4;

        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 1;
        A[5] = 1;
        A[6] = 3;
        System.out.println(solution1(A,k));
    }
    public static int solution(int A[],int k){
        int cont=1;//puntuacion 0
        int pos=A[0];
        for (int i = 1; i < A.length; i++) {
            
            if(A[i]+pos>k){
                cont++;
                pos=A[i];
            }
        }
        return cont;
    }
    public static int solution1( int[] A,int K) {
       
        int result = 0;
        int length = 0;
        for (int rope : A) {
            length += rope;
            if (length >= K) {
                result++;
                length = 0;
            }
        }
        return result;
    }
}
