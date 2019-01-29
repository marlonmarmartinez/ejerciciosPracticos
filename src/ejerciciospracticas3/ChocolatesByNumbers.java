
package ejerciciospracticas3;


public class ChocolatesByNumbers {
   
    public static void main(String[] args) {
        //System.out.println(chocolates(10,4));
        System.out.println(solution(10, 4));
        System.out.println(PrintNChocolatesInaCircle(10, 4));
        System.out.println(solution1(10, 4));
    }
    
    public static int chocolates(int n, int m){
        int con=1;
        
        for (int i = 0; i < n; i++) {
            
            if((i+m)%n !=m-1){
                con++;
            }
        }
        return con;
    }
   
    public static int solution(int N, int M) {
        int[] X = new int[N];
        int i = 0;
        int count = 0;
        while(X[i] == 0) {
            X[i] = 1;
            i = (i + M) % N;            
            count++;
        }
        return count;
    }
    public static int PrintNChocolatesInaCircle(int N, int M)
{
    // these already have a known answer
    if (M == 1) return N;
    if (M == N) return 1;

    int a = N; int b = M; int temp;
    while (b != 0)
    {
        temp = b;
        b = a % b;
        a = temp;
    }

    return N / a;
}
    
     public static int solution1(int N, int M) {
        
	int lcm = N / gcd(N, M);
        return lcm;
    }
    
    public static int gcd(int a, int b) {
	    if(a % b == 0) return b;
	    return gcd(b,a%b);
	}
}
