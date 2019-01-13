
package ejerciciospracticas;
import java.util.*;

public class binarygap {

    
    public static void main(String[] args) {
       /*binarygap mostrar=new binarygap();
        int n=15;
        int secuencia=mostrar.solution(n);
        System.out.println(secuencia);*/
      //---------------------------------------------------
       /* rotacionciclica rota= new rotacionciclica();
        int arra[]=new int [3];
        arra[0]=4;
        arra[1]=6;
        arra[2]=5;
        System.out.println(Arrays.toString(rota.rotar(arra, 2)));*/
        //----------------------------------------------------------
        
        /*OddOccurrencesInArray sinpar=new OddOccurrencesInArray();
        int array[]=new int [7];
        array[0]=9;
        array[1]=7;
        array[2]=9;
        array[3]=3;
        array[4]=9;
        array[5]=9;
        array[6]=3;
        System.out.println(sinpar.sinpareja(array));*/
        binarygap mostrar=new binarygap();
        int x=10;int y=85;int d=30;int saltos;
        saltos=mostrar.solution(x, y, d);
        System.out.println(saltos);
        
    }
    /*public int solution(int N) {
    int b = 0;
    boolean encontre = false;

    for (int i = 0; N > 0; N /= 2) {
        if (N % 2 == 0) {
            i++;
        } else {
            if (i > b && encontre == true){
                b = i;
            }
            encontre = true;
            i = 0;
        }
    }

    return b;
}*/
    public int solution(int x,int y,int d){
        int s=x;
        int c=0;
        while (s<y) {            
            s=s+d;
            c++;
        }
        return c;
   /* int diff =y - x;
    int count = diff / d;
    if (diff % d > 0) {
        count++;
    }
    return count;*/
    }
}

