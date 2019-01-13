package ejerciciospracticas2;

public class CountFactors {

    public static void main(String[] args) {
        CountFactors c = new CountFactors();
        int N = 24;

        System.out.println(c.solution(N));
    }

    private int solution(int N) {
        int contador = 0;

        for (int i = 1; i <= N; i++) {
            if (N == (N / i) * i) {
                contador++;
            }

        }
        return contador;
    }
   

    public int solution1(int N) {
        // write your code in Java SE 8
        int numFactors = 0;
        for (int i = 1; i <= (double) Math.sqrt(N); i++) {
            if (N % i == 0) {
                if (i * i != N) {
                    numFactors = numFactors + 2;
                } else if (i * i == N) {
                    numFactors = numFactors + 1;
                }
            }
        }
        return numFactors;
    }

    public int solution2(int N) {
        int result = 0;
        for (int i = 1; i <= (double) Math.sqrt(N); i++) {
            if (i == (double) Math.sqrt(N)) {
                result++;
            } else if (N % i == 0) {
                result = result + 2;
            }

        }

        return result;
    }
}
