package ejerciciospracticas3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CountDistinctSlices {

    public static void main(String[] args) {
        int m = 6;
        int[] A = new int[5];
        A[0] = 3;
        A[1] = 4;
        A[2] = 5;
        A[3] = 5;
        A[4] = 2;
        
        System.out.println(solution2(m, A));
        //System.out.println(solution1(A));
    }
    public static int solution(int m,int []A){
         long slices=0;
        int begin=0,end=0;
        HashSet<Integer> set = new HashSet<>();
        while(end<=A.length-1)
        {
            while(set.contains(A[end])==false)
            {
                set.add(A[end]);
                end++;
                if(end==A.length)
                {
                    break;
                }
            }
            slices += ((end-begin)*(end-begin+1))/2;
            if(slices>1000000000)
            {
                return 1000000000;
            }
            begin=end;
            set.clear();
        }
        return (int)slices;
    }
    public static int solution2(int M, int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int lastIndex = -1;
        for (int i = 0;i < A.length; i++) {
            int preOccurIndex = map.containsKey(A[i]) ? map.get(A[i]) : -1; 
            lastIndex = Math.max(preOccurIndex, lastIndex);
            result += i - lastIndex;
            if (result >= 1000000000) {
                return 1000000000;
            }
            map.put(A[i], i);
        }
        return result;
    }
    
    public static int solution1(int[]A){
     // array to remember last positions of values
        int vMax = A[0];
        for (int i = 1; i < A.length; ++i) {
            vMax = Math.max(vMax, A[i]);
        }
        int[] vLastPos = new int[vMax + 1];
        for (int i = 0; i < vLastPos.length; ++i) {
            vLastPos[i] = -1;
        }
        // each element adds the same number of slices as is the length of current distinct slice
        int vSlices = 0, vNewStart = -1;
        for (int i = 0; i < A.length; ++i) {
            int vVal = A[i];
            int vPrevPos = vLastPos[vVal];
            vSlices += i - Math.max(vPrevPos, vNewStart);
            if (vSlices > 1000000000) {
                return 1000000000;
            }
            if (vPrevPos != -1) {
                vNewStart = Math.max(vNewStart, vPrevPos); // actual start of distinct slice
            }
            vLastPos[vVal] = i;
        }
        return vSlices;
    }
}
