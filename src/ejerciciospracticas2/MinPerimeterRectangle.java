package ejerciciospracticas2;

public class MinPerimeterRectangle {

    public static void main(String[] args) {
        MinPerimeterRectangle m = new MinPerimeterRectangle();
        int N = 30;
        System.out.println(m.solution1(N));
    }

    public int solution(int N) {
        int minPer = Integer.MAX_VALUE;

        for (int i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                minPer = Math.min(minPer, 2 * (N / i + i));
            }
        }

        return minPer;
    }

    public int solution1(int N) {
        Integer x = ((Double) Math.sqrt(N)).intValue();
        int y = 0;
        for (int i = x; x > 0; x--) {
            if (N % x == 0) {
                y = N / x;
                break;
            }
        }
        return 2 * (x + y);
    }
}
