import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> heap = new PriorityQueue<>();
        for(int i : scoville) {
            heap.offer(i);
        }
        
        int cnt = 0;
        
        while(heap.size() > 1) {
            int a = heap.poll();
            
            if(a >= K) break;
                
            int b = heap.poll();
            
            cnt ++;
            
            heap.offer(scovilleFunction(a,b));
        }
        
        int answer = cnt;
        
        if(heap.size() <= 1) {
            if(heap.peek() < K) answer = -1;
        }
        
        return answer;
    }
    
    public int scovilleFunction(int a, int b) {
        return a + 2*b;
    }
}