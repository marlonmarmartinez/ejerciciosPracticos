
package ejerciciospracticas;

import java.util.Arrays;


public class MaxCounter {
    public static void main(String[] args) {
        MaxCounter m=new MaxCounter();
        int []A=new int[7];int n=5;
            A [0] = 3;
            A [1] = 4;
            A [2] = 4;
            A [3] = 6;
            A [4] = 1;
            A [5] = 4;
            A [6] = 4;
            System.out.println(Arrays.toString(m.solution1(n, A)));
    }
    public int[] solution(int N, int[] A) {
      int length = A.length, maxOfCounter = 0, lastUpdate = 0;
      int applyMax = N + 1;
      int result[] = new int[N];
      for (int i = 0; i < length; ++i ) {
          if(A[i] == applyMax){
              lastUpdate = maxOfCounter;
          } else if (A[i] <= N)  {
              int position = A[i]-1;
              result[position] = result[position] > lastUpdate
                                        ? result[position] + 1 : lastUpdate + 1;
              // updating the max for future use
              if(maxOfCounter <=  result[position]) {
                  maxOfCounter = result[position];
              }
          }
     }
     // updating all the values that are less than the lastUpdate to the max value
     for (int i = 0; i < N; ++i) {
         if(result[i] < lastUpdate) {
             result[i] = lastUpdate;
         }
     }
     return result;
   }
     public int[] solution1(int N, int[] A) {
        if (N == 0 || A.length == 0) {
            return new int[0];
        }
        int[] count = new int[N];
        int currentMax = 0;
        int currentMaxApplied = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                if (count[A[i] - 1] < currentMaxApplied) {
                    count[A[i] - 1] = currentMaxApplied + 1;
                } else {
                    count[A[i] - 1]++;
                }
                currentMax = Math.max(count[A[i] - 1], currentMax);
            } else {
                currentMaxApplied = currentMax;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] < currentMaxApplied) {
                count[i] = currentMaxApplied;
            }
        }
        return count;
    }
}
