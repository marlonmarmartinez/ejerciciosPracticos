
package ejerciciospracticas;


public class CountDiv {
    
    public static void main(String[] args) {
        CountDiv c=new CountDiv();
        int a=10,b=10,k=2;
        System.out.println(c.solution(a, b, k));
    }
    
    public int solution(int a,int b, int k){
        int contador=0;
        
        for(int i=a;i<=b;i++){
           
            if(i%k==0 && a<2000000000 && b>0 && b<2000000000){
                contador++;
            }
           
        }
        return contador;
    }
    public static int solution1(int A, int B, int K) {
        
		return (B/K) - (A/K) + (A%K == 0 ? 1 : 0);
    }
}
