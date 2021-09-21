package Programmers.YAPP.Week22;

import java.util.LinkedList;
import java.util.Stack;

public class 프렌즈4블록 {
    class Block {
        public int row;
        public int col;
        public String content;

        Block(int row, int col, String content) {
            this.row = row;
            this.col = col;
            this.content = content;
        }
    }

    class Solution {
        int answer = 0;
        int M, N;
        Stack<Block> stack;
        LinkedList[] nBoard;
        public int solution(int m, int n, String[] board) {
            M = m; // 행
            N = n; // 열
            stack = new Stack<>();
            nBoard = new LinkedList[N];
            for(int i = 0; i < N; ++i){
                nBoard[i] = new LinkedList<String>();
            }

            for(int i = 0; i < M; ++i){ // 초기화
                String[] temp = board[i].split("");
                for(int j = 0; j < N; ++j){
                    nBoard[j].add(temp[j]);
                }
            }

            while(true){
                for(int i = 0; i < N - 1; ++i){ // 열
                    for(int j = 0; j < M - 1; ++j){ // 행
                        String target = (String)(nBoard[i].get(j)); // i = 행, j = 열
                        if(!target.equals("0") &&
                                canDelete(j, i, target)) stack.push(new Block(j, i, target));
                    }
                }
                if(stack.isEmpty()) break;
                else {
                    while(!stack.isEmpty()) deleteBlock(stack.pop());
                    for(int i = 0; i < N; ++i){ // 열
                        for(int j = 0; j < nBoard[i].size(); ++j){ // 행
                            if(nBoard[i].get(j).equals("0")) {
                                stack.push(new Block(j, i, (String)nBoard[i].remove(j)));
                                j--;
                            }
                        }
                        while(!stack.isEmpty()) nBoard[i].addFirst(stack.pop().content);
                    }
                }
            }
            return answer;
        }

        public boolean canDelete(int row, int col, String target) {
            for(int i = col; i <= col + 1; ++i){
                for(int j = row; j <= row + 1; ++j){
                    if(!nBoard[i].get(j).equals(target)) return false;
                }
            }
            return true;
        }

        public void deleteBlock(Block b) {
            int cnt = 0;
            for(int i = b.col; i <= b.col + 1; ++i){
                for(int j = b.row; j <= b.row + 1; ++j){
                    if(nBoard[i].get(j).equals(b.content)) {
                        nBoard[i].remove(j);
                        nBoard[i].add(j, "0");
                        cnt++;
                    }
                }
            }
            answer += cnt;
        }
    }
}