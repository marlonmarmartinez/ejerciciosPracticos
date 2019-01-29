
package ejerciciospracticas4;


public class TennisTournament {
    
    public static void main(String[] args) {
        int p=5;int c=3;
        System.out.println(solution1(c, p));
    }
    
    public static int solution1(int C, int P) {
		if (P > C && C * 2 < P) {
			return C;
		}
		return P / 2;
	}
}
