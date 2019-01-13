
package ejerciciospracticas2;

import java.util.Scanner;


public class DescomponerPrimos {
    
    public static void main(String[] args) {
        
     int numero, divisor = 2;
        Scanner entrada=new Scanner(System.in);
        System.out.println("Dime un numero: ");
     //scanf("%d", &numero);
     numero=entrada.nextInt();
     System.out.printf("%d = ",numero);
 
     while ( numero >= divisor ){            
          while ( numero % divisor == 0 ) {
              System.out.printf("%d x ",divisor);   
              numero = numero / divisor;    
          }
          divisor ++;
     }
     System.out.printf("%d",numero);
    } 
}
