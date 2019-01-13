
package ejerciciospracticas2;

import java.util.ArrayList;


public class Banderas {
    
     public static void main(String[] args) {
        Banderas p = new Banderas();
        int[] A = new int[12];
        A[0] = 1;
        A[1] = 2;
        A[2] = 3;
        A[3] = 4;
        A[4] = 3;
        A[5] = 4;
        A[6] = 1;
        A[7] = 2;
        A[8] = 3;
        A[9] = 4;
        A[10] = 6;
        A[11] = 2;
        
        System.out.println(p.solution(A));
    }

    public int solution(int[] A) {
        if(A.length==1)  return 0;
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=1;i<A.length-1;i++)
        {
          if(A[i]>A[i-1] && A[i]>A[i+1])
          {
             al.add(i);
          }
        }
        int s=al.size();
        if(s==1) return 1;
        if(s==0)return 0;
        s=(int) Math.ceil(Math.sqrt(A.length));
        while(s>=0) {
            int lp=al.get(0);
            int c=1;
            for(int i=1;i<al.size();i++)
            {
                int d=Math.abs(al.get(i)-lp);
                if(d>=s)
                {
                    lp=al.get(i);
                    c++;
                    if(c==s)
                        return c;
                }
            }
            s--;}
        return 0;
    }
}
