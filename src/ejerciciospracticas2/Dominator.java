
package ejerciciospracticas2;


public class Dominator {
    
    public static void main(String[] args) {
        Dominator d=new Dominator();
        int []A=new int[8];
        A[0] = 3;    A[1] = 4  ;  A[2] =  3;
        A[3] = 2 ;   A[4] = 3 ;   A[5] = -1;
        A[6] = 3  ;  A[7] = 3;
        
        System.out.println(d.solution1(A));
    }
    
   
    
     public int solution2(int[] A) {
        
        int value=0;
        int dominator_index=-1;
        int size=0;
        
        for(int i=0; i<A.length; i++){
            if(size==0){
                value=A[i];
                size++;
            }
            else{
                if(value!=A[i]){
                    size--;
                }
                else{
                
                    size++;
                }
            }
        
        }
        
        int candidate=0;
        if(size>0){
            candidate=value;
        }
        int count=0;
        int index=0;
        for(int j=0; j<A.length; j++){
            if(A[j]==candidate){
                count++;
                index=j;
            }
        
        }
        if(count>A.length/2){
            dominator_index=index;
        }
        return dominator_index;
    }
    

public int solution1(int[] A) {
        int indexOfCandidate = -1;
        int stackCounter = 0, candidate=-1, value=-1, i =0;
        for(int element: A ) {
            if (stackCounter == 0) {
                value = element;
                ++stackCounter;
                indexOfCandidate = i;
            } else {
                if (value == element) {
                    ++stackCounter;
                } else {
                    --stackCounter;
                }
            }
            ++i;
        }
        if (stackCounter > 0 ) {
            candidate = value;
        } else {
            return -1;
        }
        int countRepetitions = 0;
        for (int element: A) {
            if( element == candidate) {
                ++countRepetitions;
            }
            if(countRepetitions > (A.length / 2)) {
                return indexOfCandidate;
            }
        }
        return -1;
    }
}
