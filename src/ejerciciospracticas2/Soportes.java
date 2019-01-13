
package ejerciciospracticas2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Soportes {
    
    public static void main(String[] args) {
        Soportes s=new Soportes();
        String S = "([)()]";
        System.out.println(s.solution2(S));
    }
     public int solution2(String S){
        int parentesis=0;
        
        for (char c : S.toCharArray()) {
            if(c=='(' || c=='[' || c=='{'){
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
    
     /*public int solution1(String S) {

        // main idea: use "Stack" (push and pop)
        
        //special case
        if(S.length() == 0)
            return 1;
        
        // new Stack<Character>()
        Stack<Character> stack = new Stack<>();
        
        // scan the string (just one pass)
        for(int i=0; i< S.length(); i++){    
            // note: push "its pair"
            if( S.charAt(i) == '(' ){
                stack.push(')');
            }
            else if( S.charAt(i) == '[' ){
                stack.push(']');
            }
            else if( S.charAt(i) == '{' ){
                stack.push('}');
            }
            // pop and check
            else if( S.charAt(i) == ')' || S.charAt(i) == ']' || S.charAt(i) == '}'){
                // important: check if the stack is empty or not (be careful)
                if(stack.isEmpty() == true){
                    return 0;
                }
                else{
                    char temp = stack.pop(); // check if the stack is empty before pop!!!
                    if(temp != S.charAt(i)){ // not a pair
                        return 0;
                    }
                }
            }
        }
        // note: check if the stack is empty or not (be careful)
        if( !stack.isEmpty() ){
            return 0;
        }
        else{
            return 1;
        }
    }*/
    
    
    public static final int BALANCED = 1;
    public static final int UNBALANCED = 0;
    
    public int solution(String S) {
        if (S.isEmpty()) return BALANCED;
        Stack<Character> stack = new Stack<>(S.length());
        NestedValidatorUtil util = new NestedValidatorUtil();
        for (char c: S.toCharArray()) {
            if (stack.isEmpty()){
                if (util.isOpener(c)) {
                    stack.push(c);
                } else {
                    return UNBALANCED;
                }
            } else {
                if(util.isOpener(c)) {
                    stack.push(c);
                } else if(util.getOpenerForGivenCloser(c) == stack.peek()){
                    stack.pop();
                } else {
                    return UNBALANCED;
                }
            }
        }
        return stack.isEmpty() ? BALANCED : UNBALANCED;
    }
    public static class NestedValidatorUtil {
        private Map<Character, Character> language = new HashMap<Character, Character>(){{
            put(')','(');
            put(']','[');
            put('}','{');
            }};
        public boolean isOpener(Character c) {
            return language.values().contains(c);
        }
        public Character getOpenerForGivenCloser(Character closer) {
            return language.get(closer);
        }
    }
    public static class Stack<T> {
          public List<T> stack;
          public Stack(int capacity) {
              stack = new ArrayList<>(capacity);
          }
          public void push(T item) {
              stack.add(item);
          }
          public T pop() {
              T item = peek();
              stack.remove(stack.size() - 1);
              return item;
          }
          public T peek() {
              int position = stack.size();
              T item = stack.get(position - 1);
              return item;
          }
          public boolean isEmpty() {
              return stack.isEmpty();
          }
      }
}
