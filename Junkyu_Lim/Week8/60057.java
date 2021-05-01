import java.util.*;
import java.math.*;

class Solution {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        
        // 아무튼 가장 큰 값 1000보다 크면 상관없음
        int answer = 1000000;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            String now;
            String next = "";
            String result = "";
            
            int cnt = 1;
            
            for (int j = 0; j <= s.length() / i; j++) {
                int start = j * i;
                int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1);
                
                now = next;
                next = s.substring(start, end);
 
                if(now.equals(next)) {
                    cnt ++;
                } else {
                    result += (getCountString(cnt) + now);
                    cnt = 1;
                }
            }
            result += (getCountString(cnt) + next);
            answer = Math.min(answer, result.length());
        }
 
        return answer; 
    }
     
    public String getCountString(int cnt) {
        return cnt > 1 ? String.valueOf(cnt) : "";
    }
}