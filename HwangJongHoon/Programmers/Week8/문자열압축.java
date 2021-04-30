package Programmers.YAPP.Week8;

import java.util.*;

public class 문자열압축 {
    static class Solution {
        public int solution(String s) {
            int answer = Integer.MAX_VALUE;
            StringBuilder sb;
            Queue<String> queue;
            if(s.length() <= 1){
                return 1;
            } else {
                for(int i = 1; i <= s.length() - 1; ++i){
                    queue = new LinkedList<>();
                    for(int j = 0; i + j <= s.length(); j+=i){
                        sb = new StringBuilder(s);
                        sb.delete(0, j);
                        sb.delete(i, s.length());
                        queue.add(sb.toString());
                    }
                    if(i * queue.size() < s.length()) {
                        sb = new StringBuilder(s);
                        queue.add(sb.delete(0, i * queue.size()).toString());
                    }
                    StringBuilder zip = new StringBuilder();
                    while(!queue.isEmpty()){
                        int cnt = 0;
                        String head = queue.peek();
                        while(!queue.isEmpty() && queue.peek().equals(head)){
                            queue.poll();
                            cnt++;
                        }
                        if(cnt > 1) zip.append(cnt + head);
                        else zip.append(head);
                    }
                    answer = Math.min(answer, zip.length());
                }
                return answer;
            }
        }
    }
}