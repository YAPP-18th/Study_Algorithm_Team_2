package Programmers.YAPP.Week13;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;

public class 캐시 {
    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            List<String> list = new LinkedList<>();

            if(cacheSize == 0){
                return cities.length * 5;
            }

            for(String city : cities){
                if(list.contains(city.toLowerCase(Locale.ROOT))){
                    list.remove(city.toLowerCase(Locale.ROOT));
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 1;
                } else if(list.size() < cacheSize) {
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                } else {
                    list.remove(0);
                    list.add(city.toLowerCase(Locale.ROOT));
                    answer += 5;
                }
            }
            return answer;
        }
    }
}
