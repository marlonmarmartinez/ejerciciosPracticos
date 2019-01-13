
package ejerciciospracticas2;


public class Nesting {
    
    public static void main(String[] args) {
        Nesting n=new Nesting();
        String S = "(()(())())";
        System.out.println(n.solution(S));
    }
    
    public int solution(String S){
        int parentesis=0;
        
        for (char c : S.toCharArray()) {
            if(c=='('){
                parentesis +=1;
            }else{
                parentesis -=1;
                if(parentesis<0){
                    return 0;
                }
            }
            
        }
        if(parentesis==0){
            return 1;
        }else{
            return 0;
        }
    }
}
