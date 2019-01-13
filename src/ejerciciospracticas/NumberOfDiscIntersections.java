
package ejerciciospracticas;


public class NumberOfDiscIntersections {
    private static final int TEN_MILLION = 10000000;
    public static void main(String[] args) {
            NumberOfDiscIntersections n=new NumberOfDiscIntersections();
            int []A=new int [6];
            A[0] = 1;
            A[1] = 5;
            A[2] = 2;
            A[3] = 1;
            A[4] = 4;
            A[5] = 0;
            System.out.println(n.solution(A));
    }
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length, count = 0;
        int[] num_no_intersect = new int[N+1]; // tracks the number of discs prior to each position that doesn't intersect that position
        for (int J = 0; J < N; J++) {
            if (J <= A[J]) {
                count += J; // b/c disc J must intersect with the previous J discs
            }
            else {
                count += A[J]; // b/c disc J must intersect with the previous A[J] discs
                count += J-A[J] - num_no_intersect[J-A[J]]; // add number of discs before J's left border that intersect it
            }
            if (count > TEN_MILLION)
                return -1; // check for exceptional case
            num_no_intersect[J+1] += num_no_intersect[J]; // discs b/f position J also won't intersect position J+1
            if (A[J] < N && J+A[J]+1 < N) { // check bounds on A[J] to avoid arithmetic overflow
                num_no_intersect[J+A[J]+1]++; // disc J will not intersect positions on or after position J+A[J]+1
            }
        }
        return count;
    }
}
