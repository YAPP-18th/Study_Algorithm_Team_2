import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities){
        if(cacheSize == 0) return cities.length * 5;

        int answer = 0;
        LinkedList<String> list = new LinkedList<>();

        for (String city : cities) {
            answer += putData(list, cacheSize, city.toLowerCase());
        }

        return answer;
    }

    public int putData(LinkedList<String> list, int cacheSize, String city){
        if(list.contains(city)){
            list.remove(city);
            list.add(city);
            return 1;
        }

        if(list.size() < cacheSize){
            list.add(city);
        }

        if(list.size() == cacheSize && !list.contains(city)){
            list.removeFirst();
            list.add(city);
        }

        return 5;
    }
}
