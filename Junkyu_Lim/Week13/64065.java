// 튜플
// 서브스트링으로 앞 뒤 괄호를 제거하고, ,로 스플릿
// 
import java.util.*;

class Solution {
    public int[] solution(String s) {
        ArrayList<String> strings = new ArrayList<>();
        LinkedHashSet<Integer> result = new LinkedHashSet<>();

        // 전처리(중괄호 제거 및 ,로 스플릿)
        for(String str : splitComma(removeBrace(s))) {
            strings.add(str);
        }
        
        // 길이 순서로 정렬
        Collections.sort(strings, (s1, s2) -> s1.length() - s2.length());
        
        // int형으로 변환 후 set에 투입
        for(String string : strings) {
            String[] splitString = string.split(",");
            ArrayList<Integer> intArray = ConvertIntArrayToString(splitString);
            intArray.stream().forEach(element -> result.add(element));
        }
        // int[] answer = new int[result.size()];
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    
    private String removeBrace(String target) {
        return target.substring(2, target.length() - 2);
    }
    
    private String[] splitComma(String target) {
        return target.split("\\}\\,\\{");
    }
    
    private ArrayList<Integer> ConvertIntArrayToString(String[] stringArr) {
        ArrayList<Integer> intArray = new ArrayList<>();
        for(String str : stringArr) {
            intArray.add(
                Integer.parseInt(str)
            );
        }
        
        return intArray;
    }
}
