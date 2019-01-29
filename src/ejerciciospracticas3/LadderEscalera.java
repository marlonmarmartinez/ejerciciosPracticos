
package ejerciciospracticas3;

import java.util.Arrays;


public class LadderEscalera {
    
    public static void main(String[] args) {
        int []A=new int[5];int []B=new int[5];
         A[0] = 4;   B[0] = 3;
        A[1] = 4;   B[1] = 2;
        A[2] = 5;   B[2] = 4;
        A[3] = 5;   B[3] = 3;
        A[4] = 1;   B[4] = 1;
        
        System.out.println(Arrays.toString(solution3(A, B)));
    }
    public static int[] solution(int[] A, int[] B) {

        // The task is to find out the number of ways 
        // someone can climb up a ladder of N rungs 
        // by ascending one or two rungs at a time.
        // It is not very hard to see that 
        // this number is just the "Fibonacci number of order N"
        
        // we implemented an easy dynamic programming approach 
        // to compute Fibonacci numbers, this will take complexity O(n)
        
        // I use binary operators to keep track of "N modulo 2^{30}" 
        // otherwise. the Fibonacci numbers will cause a memory overflow (be careful~!!)
        // and we are also asked to return "numbers modulo some power of 2"
        
        int L = A.length;
       
        // determine the "max" for Fibonacci
        int max = 0;
        for (int i = 0; i < L; i++) {
            max = Math.max(A[i], max);
        }
        //max += 2; // for Fibonacci
        
        int[] fibonacci = new int[max+1]; // plus one for "0"
        
        // initial setting of Fibonacci (importnat)
        fibonacci[0] =1;
        fibonacci[1] =1;

        for(int i=2; i<= max; i++){
            fibonacci[i] = (fibonacci[i-1] + fibonacci[i-2]) % (1 << 30);
            // we want to find the result of "a number modulo 2^P"
            // if we first let the number modulo 2^Q (Q > P) 
            // then, modulo 2^P, the esult is the same.
            // So, "we first modulo 2^30" to avoid overflow
            // where, 2^30 == 1 << 30 
        }
        
        // to find "results"
        int[] results = new int[L];
        
        for(int i=0; i<L; i++){
            results[i] = fibonacci[A[i]] % (1 << B[i]); // where, "1 << B[i]" means 2^B[i]
        }
        
        return results;
    }
     public static int[] solution1(int[] A, int[] B) {
        // for a given N rungs, the number of different ways of climbing is the (N+1)th element in the Fibonacci numbers.
		// we know that the result of a number modulo 2^P is the bit under P, so
        // if we first let the number modulo 2^Q(Q > P) and then modulo 2^P, the
        // result is the same.
        int L = A.length;
        int[] fib = new int[L+2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= L; i++) {
            // make sure the fibonacci number will not exceed the max integer in java 1<<n = 2^n
            fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
        }
        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
        return result;
    }
     static final int LIMIT = 30000;
	static final int MODULO = 1 << 30;

	public int[] solution2(int[] A, int[] B) {
		int[] fibonacci = new int[LIMIT + 1];
		fibonacci[0] = 1;
		fibonacci[1] = 1;
		for (int i = 2; i < fibonacci.length; i++) {
			fibonacci[i] = (fibonacci[i - 2] + fibonacci[i - 1]) % MODULO;
		}

		int[] ways = new int[A.length];
		for (int i = 0; i < ways.length; i++) {
			ways[i] = fibonacci[A[i]] % (1 << B[i]);
		}
		return ways;
	}
        public static int[] solution3(int[] A, int[] B) {
        // write your code in Java SE 8
        // we know that the result of a number modulo 2^P is the bit under P, so
        // if we first let the number modulo 2^Q(Q > P) and then modulo 2^P, the
        // result is the same.
        int L = A.length;
        int[] fib = new int[L+2];
        int[] result = new int[L];
        fib[1] = 1;
        fib[2] = 2;
        for (int i = 3; i <= L; i++) {
            // make sure the fibonacci number will not exceed the max integer in java
            fib[i] = (fib[i-1] + fib[i-2]) % (1 << 30);
        }
        for (int i = 0; i < L; i++) {
            result[i] = fib[A[i]] % (1 << B[i]);
        }
        return result;
    }
}
