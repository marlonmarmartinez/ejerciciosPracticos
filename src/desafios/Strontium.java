/*
 Se da una serie de N palabras. Cada palabra consta de letras pequeñas ('a' - 'z'). 
Nuestro objetivo es concatenar las palabras de tal manera que se obtenga una sola 
palabra con la subcadena más larga posible compuesta de una letra en particular. 
Encuentra la longitud de dicha subcadena.

Escribe una función:

class Solution {public int solution (String [] palabras); }

eso, dada una matriz de palabras que contiene N cadenas, devuelve la longitud de la 
subcadena más larga de una palabra creada como se describe anteriormente.

Ejemplos:

1. Dado que N = 3 y palabras = ["aabb", "aaaa", "bbab"], su función debería regresar 6. 
Una de las mejores concatenaciones son las palabras [1] + palabras [0] + palabras [2] = "aaaaaabbbbab". 
La subcadena más larga se compone de la letra 'a' y su longitud es 6.

2. Dado que N = 3 y palabras = ["xxbxx", "xbx", "x"], su función debería regresar 4. 
Una de las mejores concatenaciones son las palabras [0] + palabras [2] + palabras [1] = "xxbxxxxbx". 
La subcadena más larga se compone de la letra 'x' y su longitud es 4.

3. Dado que N = 4 y palabras = ["dd", "bb", "cc", "dd"], su función debería regresar 4. 
Una de las mejores concatenaciones son las palabras [0] + palabras [3] + palabras [1] + palabras [2] = "ddddbbcc". 
La subcadena más larga se compone de la letra 'd' y su longitud es 4.
"bb", "b", "aaa", "ab", "bba"
 */
package desafios;

import java.util.Arrays;

public class Strontium {

    //ConcatenatingOfWords
    public static void main(String[] args) {
        String[] palabras = {"bb", "b", "aaa", "ab", "bba"};
        int n=5;
        //String[] palabras = "dd,bb,cc,dd".split(",");
        /*String []c=new String[palabras.length/2];
        int j=0;
        if(palabras.length % 2==0){
        for (int i = 0; i < c.length; i++) {
        
        
        c[i]=palabras[j]+palabras[j+1];
        j=j+2;
        }
        Perm2(c, "", n/2, palabras.length/2);
        
        }else{
        Perm2(palabras, "", palabras.length, palabras.length);
        }*/
        
 /* Arrays.sort(palabras);
        System.out.println(Arrays.toString(palabras));*/
        //Perm2(c, "", 2, 2);
        //solution(palabras);
        System.out.println(solution(palabras,n));
       
        Perm2(palabras, "", n, palabras.length);
    }

    public static int solution(String[] palabras,int n) {
        Arrays.sort(palabras);
        String concatenar = "";
        int j = 0;
        int cont = 1;
        int menor = 1;
        if (palabras.length % 2 != 0) {
            int size = palabras.length;String act="";
            String[] cyclic = new String[size];
            for (int x = 0; x < size; x++) {
                cyclic[(x + 1) % size] = palabras[x];
            
            }
            
            /*for (int i = 0; i < size; i++) {
            concatenar = concatenar + cyclic[i];
            }*/
            
            for (int i = 0; i < palabras.length; i++) {
                if (!act.contains(cyclic[i])) { // Controla que no haya repeticiones
                    concatenar=concatenar+act + cyclic[i];
                    n-=1;
                }
                
            }
            for (int i = 1; i < concatenar.length(); i++) {
                
                if (concatenar.charAt(j) == concatenar.charAt(i)) {
                    cont++;

                    if (menor < cont) {
                        menor = cont;
                    }
                } else {
                    cont = 1;
                }
                j++;
            }
            //System.out.println(concatenar);
            //System.out.println(menor);
        } else {
            String []c=new String[palabras.length/2];
            int k=0;String act="";
            for (int i = 0; i < c.length; i++) {
        
            c[i]=palabras[k]+palabras[k+1];
            k=k+2;
        }
            /*for (int i = 0; i < palabras.length; i++) {
            concatenar = concatenar + palabras[i];
            }*/
            
            for (int i = 0; i < c.length; i++) {
                if (!act.contains(c[i])) { // Controla que no haya repeticiones
                    concatenar=concatenar+act + c[i];
                    n-=1;
                }
                
            }
            
            for (int i = 1; i < concatenar.length(); i++) {
                if (concatenar.charAt(j) == concatenar.charAt(i)) {
                    cont++;

                    if (menor < cont) {
                        menor = cont;
                    }
                } else {
                    cont = 1;
                }
                j++;
            }
            //System.out.println(concatenar);
            //System.out.println(menor);
        }
        return menor;
    }

    private static void Perm2(String[] elem, String act, int n, int r) {
         
        if (n == 0) {
            
            System.out.println(act);
            
        } else {
            for (int i = 0; i < r; i++) {
                if (!act.contains(elem[i])) { // Controla que no haya repeticiones
                    Perm2(elem, act + elem[i] + ",", n - 1, r);
                }
            }

        }
       
    }
}
