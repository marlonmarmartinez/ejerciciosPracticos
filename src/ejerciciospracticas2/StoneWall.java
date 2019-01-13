
package ejerciciospracticas2;

//pila de bloques

import java.util.Stack;

public class StoneWall {
    
    public static void main(String[] args) {
        StoneWall s=new StoneWall();
        int []H=new int [9];
        H [0] = 8; H [1] = 8; H [2] = 5 ;
        H [3] = 7 ;H [4] = 9 ;H [5] = 8 ;
        H [6] = 7 ;H [7] = 4; H [ 8] = 8;
        System.out.println(s.solution(H));
    }
    public int solution(int []H){
       Stack<Integer> st = new Stack<>();
        int numBlock =0;
    
        // note: H[i] is the ith height of the wall
        for(int i=0; i< H.length; i++){
        
            // step 1: "stack is not empty" AND "from high to low"
            // then, "pop" (it is the key point, be careful)
            while( st.isEmpty()==false && st.peek() > H[i] ){
                st.pop();
            }
            // step 2: if the stack is empty
            if( st.isEmpty() ){
                numBlock++;     // add a block
                st.push(H[i]);  // push the height
            }
            // step 3: the height is the same: do nothing
            else if( st.peek() == H[i] ){
            } 
            // step 4: from low to high 
            else if( st.peek() < H[i] ){
                numBlock++;    // add a block
                st.push(H[i]); // push the height
            }
        }
        
        return numBlock;
    
            
        
    }
}
