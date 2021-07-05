import java.util.*;

class Solution {
    ArrayList<String> baseNumberList = new ArrayList<>();
    
    public String solution(int n, int t, int m, int p) {
        // 참가하는 인원 * (구할 숫자의 갯수 - 1) + 순서
        int goal = m * (t - 1) + p;
        
        baseNumberList.add("0");
        baseNumberList.add("0");
        
        for(int num = 1; num < goal; num ++) {
            String result = convertNum(num, n); 
            Arrays.stream(
                result.split("")
            ).forEach(
                number -> baseNumberList.add(number)
            );
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int cnt = 0; cnt < t; cnt ++) {
            sb.append(
                baseNumberList.get(m * cnt + p)
            );
        }
        
        String answer = sb.toString();
        return answer;
    }
    
    private String convertNum(int num, int baseN) {
        StringBuilder sb = new StringBuilder();
        
        int tmp = num;
        while(tmp > 0) {
            int remain = tmp % baseN;
            buildConvertNum(sb, remain);
            tmp /= baseN;
        }
        
        return sb.reverse().toString();
    }
    
    private StringBuilder buildConvertNum(StringBuilder sb, int remain) {
        if(remain < 10) {
            return sb.append(remain);
        }
        
        return sb.append((char)(remain - 10 + 'A'));
    }
}
