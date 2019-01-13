package ejerciciospracticas2;

public class MaxProfit {

    public static void main(String[] args) {
        MaxProfit m = new MaxProfit();
        int[] A = new int[6];
        A[0] = 23171;
        A[1] = 21011;
        A[2] = 21123;
        A[3] = 21366;
        A[4] = 21013;
        A[5] = 21367;
        System.out.println(m.solution(A));
    }
public int maxProfit(int[] A) {
    if(A.length == 1 || A.length == 0){
        return 0;
    }
    
    int maxSoFar = 0;
    int maxEndingHere = 0;
    int minPrice = A[0];
    
    for(int i = 1; i < A.length; i++){
        maxEndingHere = Math.max(0, A[i] - minPrice);
        minPrice = Math.min(minPrice, A[i]);
        maxSoFar = Math.max(maxEndingHere, maxSoFar);
    }
    
    return maxSoFar;
}


public int maxProfit1(int[] A) {
        int maxEnd = 0;
        int maxSlice = 0;
        if (A.length < 2) return 0;
        for (int i = 1; i < A.length; i++) {
            int delta = A[i] - A[i - 1];
            maxEnd = Math.max(0, maxEnd + delta);
            maxSlice = Math.max(maxSlice, maxEnd);
        }
        if(maxSlice < 0) return 0;
        return maxSlice;
    }
 public int solution(int[] A) {
       if(A.length == 0) return 0 ;
       int min = A[0]; //mainin the previous min price
       int profit = 0; //current max profit
       for(int i=1 ; i < A.length ;i++){
           min =  Math.min(min,A[i]); //update minimum
           profit = Math.max(profit, A[i] - min); //calculate current profit
       }
       return profit > 0 ? profit : 0 ;
    }
}
