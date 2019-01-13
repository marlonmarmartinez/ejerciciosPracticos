
package ejerciciospracticas;

public class PermMissingElem {
    
    public static void main(String[] args) {
        PermMissingElem p=new PermMissingElem();
        int [] A=new int [5];
        A[0] = 2;
        A[1] = 3;
        A[2] = 1;
        A[3] = 4;
        A[4]=6;
        System.out.println(p.solution(A));
    }
    public int solution(int[] A) {

        long N = A.length + 1;
        long total = N * (N + 1) / 2;

        for (int i : A) {

            total -= i;
        }

        return (int)total;
    }
    public final int solution1(final int[] data) {

        final long N = data.length + 1;
        final long total = (N * (N + 1)) / 2;

        long sum = 0L;

        for (final int i : data) {

            sum += i;
        }

        return (int)(total - sum);
    }
    public int solution2(int[] A)
    {
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] == 0)
            {
                continue;
            }
            int n = A[i] - 1;
            while (n != -1 && n < A.length)
            {
                int next = A[n] - 1;
                A[n] = 0;
                n = next;
            }
        }
        for (int i = 0; i < A.length; i++)
        {
            if (A[i] != 0)
            {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
