import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> st = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = progresses.length-1; i >= 0; i--) {
            st.push(progresses[i]);
            st2.push(speeds[i]);
        }
        int date = 0;
        
        while(!st.isEmpty()) {
            date ++;
            int cnt = 0;
            while(!st.isEmpty()) {
                int a = st.pop();
                int b = st2.pop();
                if(a + (date*b) >= 100) {
                    cnt ++;
                } else {
                    st.push(a);
                    st2.push(b);
                    break;
                }
            }
            if(cnt != 0) res.add(cnt);
        }
        int[] answer = new int[res.size()];
        for(int j = 0; j < res.size(); j++) {
            answer[j] = res.get(j);
        }
        return answer;
    }
}