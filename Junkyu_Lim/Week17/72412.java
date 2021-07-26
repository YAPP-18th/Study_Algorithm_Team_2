import java.util.*;

class Solution {
    
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> hs = new HashMap<>();
        int[] answer = new int[query.length];
        
        for (String in : info) {
            String[] info_split = in.split(" ");
            int score = Integer.parseInt(info_split[4]);

            for (int i = 0; i < (1 << 4); i++) {
                StringBuilder key = new StringBuilder();
                for (int j = 0; j < 4; j++) {
                    if ((i & (1 << j)) > 0) key.append(info_split[j]);
                }
                
                hs.computeIfAbsent(key.toString(), s -> new ArrayList<>()).add(score);
            }
        }
        
        for (Map.Entry<String, List<Integer>> entry : hs.entrySet()){
            entry.getValue().sort(null);
        }
        
        for(int i = 0; i < query.length; i ++) {
            int score = Integer.parseInt(query[i].split(" ")[7]);
            String key = query[i].replaceAll("[0-9]", "")
                .replace(" and ", "")
                .replace("-", "")
                .replace(" ", "");
            
            
            // int count = (int)hs.getOrDefault(key, new ArrayList<Integer>()).stream().filter(x -> score <= x).count();
            List<Integer> rs = hs.getOrDefault(key, new ArrayList<Integer>());
            
            int start = 0;
            int end = rs.size();
            
            while (start < end) {
                int mid = (start + end) / 2;
                
                if(rs.get(mid) < score) 
                    start = mid + 1;
                else
                    end = mid;
            }
            
            int count = rs.size() - start;
            
            answer[i] = count;
        }
        
        
        return answer;
    }
}
