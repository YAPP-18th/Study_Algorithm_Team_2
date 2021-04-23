import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int index : scoville){
            pq.offer(index);
        }
        
        while(pq.peek() <= K){
            if(pq.size() == 1) return -1;
            int x = pq.poll();
            int y = pq.poll();
            
            int mix = x + y * 2;
            pq.offer(mix);
            answer += 1;
        }
        
        return answer;
    }
}
