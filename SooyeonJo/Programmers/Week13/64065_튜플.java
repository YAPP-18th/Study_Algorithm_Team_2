import java.util.*;

class Solution {
    public int[] solution(String s){
        HashSet<String> set = new HashSet<>();
        String[] arr = s.replaceAll("//{", " ").replaceAll("}", " ").trim().split(" , ");

        // Arrays.sort(arr, (a, b)-> a.length() - b.length());
        Arrays.sort(arr, Comparator.comparingInt(String::length));

        int[] answer = new int[arr.length];
        int i=0;
        
        for (String elements : arr) {
            for(String num : elements.split(",")){
                if(set.add(num)){
                    answer[i] = Integer.parseInt(num);
                    i++;
                }
            }
        }

        return answer;
    }
}
