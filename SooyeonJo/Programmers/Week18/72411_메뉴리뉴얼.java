import java.util.*;

class Solution {
    public static HashMap<String, Integer> map;
    public static int max;
    
    public String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int numberOfCourse : course) {
            map = new HashMap<>();
            max = 0;

            for (String order : orders) {
                combination("", order, 0, 0, numberOfCourse);
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max && max > 1) {
                    pq.offer(key);
                }
            }
        }

        String[] answer = new String[pq.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }

    public void combination(String s, String order, int n, int r, int size) {
        if (r == size) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            StringBuilder sb = new StringBuilder();

            for (char value : c) {
                sb.append(value);
            }

            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            max = Math.max(max, map.get(sb.toString()));
            return;
        }

        for (int i = n; i < order.length(); i++) {
            combination(s + order.charAt(i), order, i + 1, r + 1, size);
        }
    }
}
