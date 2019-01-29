package ejerciciospracticas4;

public class FloodDepth {

    public static void main(String[] args) {
        int[] A = new int[11];
        A[0] = 1;
        A[1] = 3;
        A[2] = 2;
        A[3] = 1;
        A[4] = 2;
        A[5] = 1;
        A[6] = 5;
        A[7] = 3;
        A[8] = 3;
        A[9] = 4;
        A[10] = 2;
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        int maxH = 0;
        int minH = 0;
        int maxD = 0;
        int d = 0;
        for (int a : A) {

            if (a > maxH) {
                d = maxH - minH;
                maxH = a;
                minH = a;
            } else if (a < minH) {
                minH = a;
            } else {
                d = a - minH;

            }
            if (d > maxD) {
                maxD = d;
            }
        }
        return maxD;
    }

    public int getMaximumDepth(int[] A) {
        int highestIdx = 0;
        int lowestIdx = 0;
        int max = 0;

        for (int i = 1; i < A.length; i++) {
            int current = A[i];
            int highest = A[highestIdx];
            int lowest = A[lowestIdx];
            if (current > highest) {
                max = Math.max(highest - lowest, max);
                highestIdx = i;
                lowestIdx = highestIdx;
            } else if (current > lowest) {
                max = Math.max(current - lowest, max);
            } else if (current < lowest) {
                lowestIdx = i;
            }
        }
        return max;
    }

}
