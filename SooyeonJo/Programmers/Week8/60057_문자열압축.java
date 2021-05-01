import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
        if(answer == 1) return answer;
        
        for(int i=1; i<=s.length()/2; i++){
            int length = compress(s, i);
            answer = Math.min(answer, length);
        }
        return answer;
    }
    
    public int compress(String s, int i){
        StringBuilder sb = new StringBuilder();
        String prefix = s.substring(0, i);
        int cnt = 1;
        for(int j=i; j<s.length(); j+=i){
            String temp;
            if(j+i >= s.length()){
                temp = s.substring(j);
            }else{
                temp = s.substring(j, j+i);
            }

            if(temp.equals(prefix)){
                cnt++;
            }else{
                if(cnt == 1){
                    sb.append(prefix);
                }else{
                    sb.append(cnt).append(prefix);
                }
                cnt = 1;
                prefix = temp;
            }
        }

        if(cnt == 1) sb.append(prefix);
        else sb.append(cnt).append(prefix);

        return sb.length();
    }
}
