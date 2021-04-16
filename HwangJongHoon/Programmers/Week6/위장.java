package Programmers.YAPP.Week6;

import java.util.*;

public class 위장 {
    static class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> hm = new HashMap<>();

            for (String[] cloth : clothes) {
                hm.put(cloth[1], hm.getOrDefault(cloth[1], 0) + 1);
            }

            for (int value : hm.values()) {
                answer *= (value + 1);
            }

            // 옷을 하나도 안입는 경우는 없으니까 빼줌
            answer--;

            return answer;
        }
    }
}
