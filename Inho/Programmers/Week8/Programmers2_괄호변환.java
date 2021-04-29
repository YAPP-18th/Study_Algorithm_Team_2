import java.util.*;
class dfsfsefwe{
    public static void main(String[] args){
        
    }
    public String solution(String p) {
        if(checkRight(p)){
            return p;
        }
        return recursive(p);
    }
    public String recursive(String w){
        if(w.equals("")){
            return "";
        }
        int balanceIndex = makeBalanceIndex(w);
        String u = w.substring(0, balanceIndex);
        String v = w.substring(balanceIndex, w.length());
        
        if(checkRight(u)){
            return u + recursive(v);
        }else{
            String [] uArr = u.split("");
            String reversedU = "";
            for(String i : uArr){
                if(i.equals("(")){
                    reversedU += ")";
                }else{
                    reversedU += "(";
                }
            }
            return "(" + recursive(v) + ")" + reversedU.substring(1, reversedU.length() -1);
        }
    }
    
    public boolean checkRight(String s){
        char [] arr = s.toCharArray();
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                count++;
            }else{
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return true;
    }
    
    public int makeBalanceIndex(String s){
        char [] arr = s.toCharArray();
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == '('){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                return i+1;
            }
        }
        return arr.length;
    }
    
}