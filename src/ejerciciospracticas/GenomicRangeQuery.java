
package ejerciciospracticas;

import java.util.Arrays;


public class GenomicRangeQuery {
    
    public static void main(String[] args) {
        GenomicRangeQuery g=new GenomicRangeQuery();
        String [] S={"C","A","G","C","C","T","A"};
        int []P={2,5,0};
        int[]Q={4,5,6};
        System.out.println(Arrays.toString(g.solution(Arrays.toString(S), P, Q)));
    }
    
    public int [] solution (String S, int [] P, int [] Q){
        
         int[][] genoms = new int[3][S.length()+1];
        
        short a, c, g;
        for (int i=0; i<S.length(); i++) {
            a = 0; c = 0; g = 0;
            if ('A' == (S.charAt(i))) {
                a=1;
            }
            if ('C' == (S.charAt(i))) {
                c=1;
            }
            if ('G' == (S.charAt(i))) {
                g=1;
            }
           
            genoms[0][i+1] = genoms[0][i] + a;
            genoms[1][i+1] = genoms[1][i] + c;
            genoms[2][i+1] = genoms[2][i] + g;
        }

        int[] result = new int[P.length];
        
        for (int i=0; i<P.length; i++) {
            int fromIndex = P[i];
            int toIndex = Q[i]+1;
            
            if (genoms[0][toIndex] - genoms[0][fromIndex] > 0) {
                result[i] = 1;
            } else if (genoms[1][toIndex] - genoms[1][fromIndex] > 0) {
                result[i] = 2;
            } else if (genoms[2][toIndex] - genoms[2][fromIndex] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
    
    
    public int[] solution1(String S, int[] P, int[] Q)
    {
        int N = S.length();
        int[][] count = new int[N + 1][4];
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                count[i + 1][j] = count[i][j];
            }
            
            switch (S.charAt(i))
            {
                case 'A':
                    count[i + 1][0]++;
                    break;
                
                case 'C':
                    count[i + 1][1]++;
                    break;
                    
                case 'G':
                    count[i + 1][2]++;
                    break;
                
                case 'T':
                    count[i + 1][3]++;
                    break;
            }
        }
        
        int M = P.length;
        int[] results = new int[M];
        
        for (int i = 0; i < M; i++)
        {
            int i0 = P[i];
            int i1 = Q[i];
            
            for (int j = 0; j < 4; j++)
            {
                if (count[i1 + 1][j] - count[i0 + 0][j] > 0)
                {
                    results[i] = j + 1;
                    break;
                }
            }
        }
        
        return results;
    }
}
