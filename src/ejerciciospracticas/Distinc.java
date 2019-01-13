
package ejerciciospracticas;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;


public class Distinc {
    
    public static void main(String[] args) {
        Distinc d=new Distinc();
        int []A={2,1,1,2,3,1};
        System.out.println(d.solution(A));
    }
    public int solution(int []A){
        int con=0;
        
        //for (int i = 0; i < A.length; i++) {
            int i=0;
            for (int j = 1; j < A.length; j++) {
                
                if(A[i]!=A[j]){
                    con++;
                    
                }
                i=i+1;
            }
        //}
        return con-1;
    }
    public int solution1(int[] A) {
        Set aSet = new HashSet();
        for (int i = 0; i < A.length; i++) {
            aSet.add(A[i]);
        }
        return aSet.size();
    }
    public int solution2(int[] A) {
        Set<Integer> sparseArray = new HashSet<>();
        int distinctCount= 0;
        for(int element : A ) {
            if (!sparseArray.contains(element) ) {
                sparseArray.add(element);
                ++distinctCount;
            }
        }
        return distinctCount;
    }
    public int solution3(int[] A) {
        // first part for negatives, second part for positives and adding 1
        // to count the zero as part of the positives section
        int offset = 1_000_000;
        BitSet bitSet = new BitSet( (offset * 2) + 1 );
        for (int element : A ) {
            int index = element >= 0 ? offset + element : (element * -1);
            bitSet.set(index);
        }
        return bitSet.cardinality();
    }
    public int solution4(int[] A) {    
        return IntStream.of(A).distinct().toArray().length;
    }
}
