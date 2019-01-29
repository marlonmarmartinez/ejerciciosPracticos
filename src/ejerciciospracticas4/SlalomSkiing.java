package ejerciciospracticas4;

public class SlalomSkiing {

    public static void main(String[] args) {
        int[] A = new int[13];
        A[0] = 15;
        A[1] = 13;
        A[2] = 5;
        A[3] = 7;
        A[4] = 4;
        A[5] = 10;
        A[6] = 12;
        A[7] = 8;
        A[8] = 2;
        A[9] = 11;
        A[10] = 6;
        A[11] = 9;
        A[12] = 3;
        System.out.println(solutionM(A));
    }
    
    public static int solutionM(int []A){
        int contDerecha=1;
        int conIzquierda=1;
        int empezar=A[0];
        
        for (int i = 1; i < A.length; i++) {
            
            if(empezar>A[i]){
                contDerecha++;//1,2,3,4,5,6,7,8
                empezar=A[i];
            }else{
                conIzquierda++;//1,2,3,4,5,6
                empezar=A[i];
            }
        }
        return Math.max(contDerecha, conIzquierda);
        
    }

    public static int solution(int[] arr) {
        long left = 0;
        long right = 0;

        /* sumamos todos a la izquierda */
        for (int i : arr) {
            left += i;
        }

        /* vamos comprobando y restando a la izquierda y sumando a la dcha */
        for (int i = 0; i < arr.length; i++) {
            if (left - arr[i] == right) {
                return i;
            }
            left -= arr[i];
            right += arr[i];
        }

        return -1;
    }
}
