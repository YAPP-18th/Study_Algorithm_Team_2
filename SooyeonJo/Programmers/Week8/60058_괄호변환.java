import java.util.*;

class Solution {
    public String solution(String p) {
        if(p.length() == 0) return p;
        
        return makeCorrect(p);
    }
    
    public String makeCorrect(String s){
        if(s.length() == 0) return s;
        
        int i = getSplitIndex(s);
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        u.append(s.substring(0, i));
        v.append(s.substring(i));
        
        if(isCorrect(u.toString())){
            return u.append(makeCorrect(v.toString())).toString();
        }
        
        answer.append('(').append(makeCorrect(v.toString())).append(')');
        u.deleteCharAt(0);
        u.deleteCharAt(u.length()-1);
        return answer.append(swap(u.toString())).toString();
    }
    
    public int getSplitIndex(String s){
        int start = 0;
        int end = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                start++;
            }else{
                end++;
            }
            
            if(start == end){
                return i+1;
            }
        }
        return -1;
    }
    
    public boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
            }
        }
        
        return stack.isEmpty();
    }
    
    public String swap(String s){
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                temp.append(')');
            }else{
                temp.append('(');
            }
        }
        return temp.toString();
    }
}
