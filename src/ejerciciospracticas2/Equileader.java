/*
 El líder de esta matriz es el valor que se produce en más de la mitad de los elementos de A.
 */
package ejerciciospracticas2;


public class Equileader {
    
    public static void main(String[] args) {
        Equileader e=new Equileader();
        int []A=new int[6];
        A [0] = 4;
        A [1] = 3;
        A [2] = 4;
        A [3] = 4;
        A [4] = 4;
        A [5] = 2;
        System.out.println(e.solution(A));
    }
    public int solution(int[] A) {
        
        int size = 0;
        int value = 0;
        for (int i=0; i<A.length; i++) {
            if (size == 0) {
                size++;
                value = A[i];
            } else {
                if (A[i] == value)
                    size++;
                else 
                    size--;
            }
        }
        
        
        int count = 0;
        
        for (int j=0; j<A.length; j++) {
            if (A[j] == value) {
                 count++;
            }
        }
        
        if (count <= (A.length/2)) {
            return 0;    
        } else {
            int indices = 0;
            size = 0;
            for (int k=0; k<A.length-1; k++) {
                if (A[k] == value){ 
                    count--;
                    size++;
                }
                if ((size > ((k+1)/2)) && (count > (A.length-(k+1))/2 )) {
                    indices++;
                }
            }
            return indices;
        }
    }
}
