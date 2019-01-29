
package ejerciciospracticas3;


public class CommonPrimeDivisors {
    
    public static void main(String[] args) {
        int [] A=new int[3];
        int [] B=new int [3];
        A [0] = 15; B [0] = 75;
        A [1] = 10; B [1] = 30;
        A [2] = 3; B [2] = 5;
        
        System.out.println(solution(A, B));
    }
     public static int solution(int[] A, int[] B) {
        int count = 0;
        for(int i=0;i<A.length;i++) {
            if(hasSamePrimeDivisors(A[i], B[i])){
                count++;    
            } 
        }
        return count;
    }
    
    public static int gcd(int a, int b) {
	    if(a % b == 0) return b;
	    return gcd(b,a%b);
	}
	
	public static boolean hasSamePrimeDivisors(int a, int b) {
	    int gcdValue = gcd(a,b);
        int gcdA;
        int gcdB;
        while(a!=1) {
            gcdA = gcd(a,gcdValue);
            if(gcdA==1)
                break;
            a = a/gcdA;
        }
        if(a!=1)  {
            return false;
        }
        while(b!=1) {
            gcdB = gcd(b,gcdValue);
            if(gcdB==1)
                break;
            b = b/gcdB;
        }
        return b==1;        
	}
        
         public int solution1(int[] A, int[] B) {
            // write your code in Java SE 8
            int Z = A.length;
            int result = 0;
    
            for(int i=0; i<Z; i++) {
                if(isSameDivisors(A[i], B[i])) {
                    result++;
                }
            }
            
            return result;
        }
        
        private int gcd1(int a, int b) {
            if(a % b == 0) {
                return b;
            }
            
            return gcd(b, a%b);
        }
        
        private boolean isSameDivisors(int a, int b) {
            int gcd_ab = gcd1(a, b);
            int gcd_a = 0;
            int gcd_b = 0;
            
            while(gcd_a != 1) {
                gcd_a = gcd1(a, gcd_ab);
                a /= gcd_a;
            }
            
            while(gcd_b != 1) {
                gcd_b = gcd1(b, gcd_ab);
                b /= gcd_b;
            }
            
            return (a == 1 && b == 1) ? true : false;
        }
}
