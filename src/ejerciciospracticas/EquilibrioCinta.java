
package ejerciciospracticas;


public class EquilibrioCinta {
  
    public static void main(String[] args) {
        EquilibrioCinta c=new EquilibrioCinta();
        int [] arra=new int [5];
        arra[0]=3;
        arra[1]=1;
        arra[2]=2;
        arra[3]=4;
        arra[4]=3;
        System.out.println(c.solution(arra));
    }

    public int solution(int[] A) {
        
       
        int minimum = A.length*1000;
        int head = 0;
        int tail = 0;
        for (int i = 0; i<A.length; i++){ 
            tail+= A[i];
        }
        for(int i = 0; i<A.length-1; i++){
            head+= A[i];
            tail-= A[i];
            if (minimum>Math.abs(head-tail)) minimum = Math.abs(head-tail);
        }
        return minimum;
    
    }
}


