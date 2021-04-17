import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        int[] answer;
        
        for(int i=progresses.length-1; i>=0; i--){
            stack.add((100 - progresses[i]) / speeds[i] + ((100 - progresses[i]) % speeds[i] == 0 ? 0 : 1));
        }
        
        ArrayList<Integer> nums = new ArrayList<>();
        
        while(!stack.isEmpty()){
            int cnt = 1;
            
            int top = stack.pop();
            
            while(!stack.isEmpty() && top >= stack.peek()){
                cnt += 1;
                stack.pop();
            }
            nums.add(cnt);
        }
        
        answer = new int[nums.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = nums.get(i);
        }
        
        return answer;
    }
}
