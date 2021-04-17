package Programmers.YAPP.Week6;

import java.util.*;

public class Exam42584_주식가격 {
    static class Solution {
        public int[] solution(int[] prices) {
            int len = prices.length;
            int[] answer = new int[len];
            Stack<int[]> stack = new Stack<>();

            for(int i = len - 2; i >= 0; --i){
                if(prices[i] > prices[i + 1]){
                    answer[i] = 1;
                    stack.push(new int[] {prices[i + 1], i + 1});
                } else {
                    while(stack.size() > 0 && stack.peek()[0] >= prices[i]){
                        stack.pop();
                    }
                    if(stack.size() == 0){
                        answer[i] = len - i - 1;
                    } else {
                        answer[i] = stack.peek()[1] - i;
                    }
                }
            }
            return answer;
        }
    }
}
