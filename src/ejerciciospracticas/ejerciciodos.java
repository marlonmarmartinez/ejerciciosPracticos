
package ejerciciospracticas;

import java.util.Arrays;
import java.util.Scanner;

public class ejerciciodos {
    
    public static void main(String[] args) {
       /* int [] a  = {7,2,4,8,3,9,1,5,10,6};
         Arrays.sort(a);
          System.out.println(Arrays.toString(a));*/
       
        Scanner s=new Scanner(System.in);
        System.out.println("digite el tamaño del arreglo");
        int t=s.nextInt();
        int a0 = 0;int pos=0;
        int [] a = new int[t];
        for (int i = 0; i < t; i++) {
            System.out.println("digite un numero");
            int n=s.nextInt();
            a[i]=n;
            a0=a[0];
        }
        //System.out.println(Arrays.toString(a));
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if(a0==a[i]){
                pos=i;
                System.out.println("el primer numero introducido quedo en la posicion "+pos+" luego de ser ordenado");
            }
        }
       // System.out.println(Arrays.toString(a));
    }
}
