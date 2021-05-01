import java.util.*;
class dsfdsf{
    public static void main(String[] args){
        
    }
    public static int solution(String s) {
        int answer = s.length();
        int length = s.length();
        for(int i=1; i<= length/2; i++){
            String bfStr = "";
            int reCnt = 1; 
            int curLength = length;
            int numLength = 0;
            
            for(int j=0; j+i <=length; j += i){
                String cur = s.substring(j, j+i);
                if(bfStr.equals(cur)){
                    reCnt ++;
                    if((int)Math.floor(Math.log10(reCnt))+1 > numLength){
                        curLength += 1;
                        numLength += 1;
                    }
                    curLength -= i;
                }else{
                    bfStr = cur;
                    reCnt = 1;
                    numLength = 0;
                }
            }
            answer = Math.min(answer, curLength);
        }
        return answer;
 
    }
    
}