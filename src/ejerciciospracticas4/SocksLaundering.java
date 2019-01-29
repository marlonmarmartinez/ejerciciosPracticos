
package ejerciciospracticas4;

import java.util.Arrays;


public class SocksLaundering {
    public static void main(String[] args) {
        int K = 2; int []C = {1, 2, 1, 1};  int []D ={1, 4, 3, 2, 4};
        System.out.println(solution(K, C, D));
    }
    public static int solution(int K,int[]C,int[]D){
        int cont=0;
        Arrays.sort(C);
        Arrays.sort(D);
         int res=C[0];
         int n=0;
         int h=0;
         int cont2=0;
        for (int i = 1; i < C.length; i++) {
            
            if(res==C[i]){
                i=i+1;
                n=i;
                cont2++;
            }
                
        }
        for (int i = n; i < C.length; i++) {
            
            for (int j = 0; j < D.length; j++) {
                if(cont < K && h!=D[j])
                if(C[i]==D[j]){
                    cont++;
                    h=D[j];
                }
            }
        }
        return cont+cont2;
    }
   
    
}
