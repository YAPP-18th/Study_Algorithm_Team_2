import java.util.*;
import java.util.stream.*;

class Solution {
    final int MAX_SIZE = 11;
    ArrayList<HashMap<String, Integer>> hmList = new ArrayList<>();
    ArrayList<Integer> maxList = new ArrayList<>();
    ArrayList<String> result = new ArrayList<>();
    
    public String[] solution(String[] orders, int[] course) {
        for (int i = 0; i < MAX_SIZE; i ++) {
            hmList.add(new HashMap<String, Integer>());
            maxList.add(0);
        }
        
        for(String order : orders) {
            getComp(order);
        }
        
        for (int j = 0; j <= MAX_SIZE; j ++) {
            final int idx = j;
            
            if (IntStream.of(course).anyMatch(x -> x == idx)) {
                for (var set : hmList.get(j).entrySet()) {
                    if (maxList.get(j) <= 1) break;
                    if (set.getValue() == maxList.get(j)) result.add(set.getKey());
                }
            }
        }
        
        return result.stream().sorted().toArray(String[]::new);
    }

    private void getComp(String order) {
        String[] splitOrder = order.split("");
        Arrays.sort(splitOrder);
        StringBuilder sb;
        int size;
        String key;
        int value;

        for(int i = 0; i < (1 << order.length()); ++i){
            sb = new StringBuilder();
            for(int j = 0; j < order.length(); ++j) {
                if((i & (1 << j)) > 0) sb.append(splitOrder[j]);
            }
            size = sb.length();
            
            if (size < 2) continue;
            
            key = sb.toString();
            value = hmList.get(size).getOrDefault(key, 0) + 1;
            
            if (maxList.get(size) < value) maxList.set(size, value);

            hmList.get(size).put(key, value);
        }
    }
}
