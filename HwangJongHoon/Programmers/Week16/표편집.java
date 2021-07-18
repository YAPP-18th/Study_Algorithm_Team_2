package Programmers.YAPP.Week16;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표편집 {
    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            String command;
            StringTokenizer st;
            int tableSize = n;
            Stack<Integer> stack = new Stack<>();

            for(String c : cmd) {
                st = new StringTokenizer(c);
                command = st.nextToken();
                if(command.equals("U")) {
                    k -= Integer.parseInt(st.nextToken());
                } else if(command.equals("D")) {
                    k += Integer.parseInt(st.nextToken());
                } else if(command.equals("C")) {
                    stack.push(k);
                    tableSize -= 1;
                    if(k == tableSize) k -= 1;
                } else {
                    int removed = stack.pop();
                    if(k >= removed) k += 1;
                    tableSize += 1;
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < tableSize; i++) {
                sb.append("O");
            }
            while(!stack.isEmpty()) {
                sb.insert(stack.pop().intValue(), "X");
            }
            return sb.toString();
        }
    }
}
