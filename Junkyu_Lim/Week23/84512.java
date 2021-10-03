import java.util.*;

class Solution {
    public int solution(String word) {
        char[] a = {'A', 'E', 'I', 'O', 'U'};
        int[] count = {781, 156, 31, 6, 1};
        int length = word.length();
        int answer = length;
        int idx = 0;
        
        for (int i = 0; i < length; i ++) {
            for (int j = 0; j < 5; j ++) {
                if (word.charAt(i) == a[j]) {
                    answer += count[i] * j;
                }
            }
        }
        
        return answer;
    }
}
