class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt = 0, zeroCnt = 0;
        while(true){
            cnt++;
            int removeZeroCnt = s.replaceAll("0","").length();
            zeroCnt += s.length() - removeZeroCnt;
            s = Integer.toBinaryString(removeZeroCnt);
            
            if(s.length() == 1) break;
        }
        
        answer[0] = cnt;
        answer[1] = zeroCnt;
        return answer;
    }
}
