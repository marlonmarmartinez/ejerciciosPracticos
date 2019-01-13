
package ejerciciospracticas2;

import java.util.Stack;


public class Pez {
    
    public static void main(String[] args) {
        Pez p=new Pez();
        int []A=new int[5];
        int []B=new int[5];
        A [0] = 4; B [0] = 0;
        A [1] = 3; B [1] = 1;
        A [2] = 2; B [2] = 0;
        A [3] = 1; B [3] = 0;
        A [4] = 5; B [4] = 0;
        System.out.println(p.solution(A, B));
    }
  
    public int solution(int []A,int []B){
       Stack<Integer> fishesToFight = new Stack<>();
    int passedUpstream = 0;
    for (int i = 0; i < B.length; i++) {
        if (B[i] == 0) {
            if (fishesToFight.size() == 0){
                passedUpstream++;
            }else {
                while (!fishesToFight.empty() && A[i] > fishesToFight.peek()){
                    fishesToFight.pop();
                    if (fishesToFight.size() == 0){
                    passedUpstream++;
                    }
                }
            }
        }   else{
            fishesToFight.push(A[i]);
            }   
    }
    return fishesToFight.size() + passedUpstream;
    }
    
}
