
import java.util.*;
class Programm3 {
    public static void main(String[] arsg){
        String [][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }
    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> hm = new HashMap<>();
        for(String [] i: clothes){
            hm.put(i[1], hm.getOrDefault(i[1], 0)+1);
        }
        for(int i : hm.values()){
            answer *= (i + 1);
        }
        return answer-1;
    }
}
