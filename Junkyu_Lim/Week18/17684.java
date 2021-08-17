import java.util.*;

class Solution {
    HashMap<String, Integer> hs = new HashMap<>();
    int curIdx = 27;
    
    public int[] solution(String msg) {
        ArrayList<Integer> arr = new ArrayList<>();
        String[] msgs = msg.split("");
        int size = msgs.length;
        int idx = 0;
        String val = "";
        String next = "";
        int idxNum = 0;
        
        while (idx < size) {
            val = msgs[idx];
            idx ++;
            idxNum = val.charAt(0) - 64;
            
            while (true) {
                if (idx >= size) break;
                next = val + msgs[idx];
                
                if (hs.get(next) == null) break;
                else {
                    idx ++;
                    val = next;
                    idxNum = hs.get(next);
                }
            }
            
            arr.add(idxNum);
            if (idx >= size) break;
            hs.put(next, curIdx);
            curIdx ++;
        }
    
        
        int[] answer = new int[arr.size()];
        for(int i = 0; i < arr.size(); i++) answer[i] = arr.get(i);
        return answer;
    }
}
