package Programmers.YAPP.Week21;

import java.util.*;

public class 경주로건설 {
    static class Solution {
        int N;
        int[][][] cBoard;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};

        class Node {
            public int row;
            public int col;
            public int cost;
            public int dir;
            Node(int row, int col, int cost, int dir){
                this.row = row;
                this.col = col;
                this.cost = cost;
                this.dir = dir;
            }
        }

        public int solution(int[][] board) {
            N = board.length;
            cBoard = new int[4][N][N];
            for(int i = 0; i < cBoard.length; ++i) {
                for(int j = 0; j < cBoard[0].length; ++j) {
                    Arrays.fill(cBoard[i][j], Integer.MAX_VALUE);
                }
            }
            bfs(board);
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < 4; ++i){
                min = Math.min(min, cBoard[i][N - 1][N - 1]);
            }
            return min;
        }

        public void bfs(int[][] board){
            Queue<Node> queue = new LinkedList<>();
            for(int i = 0; i < 4; ++i) queue.add(new Node(0, 0, 0, i));
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.cost >= cBoard[node.dir][node.row][node.col]) continue;
                int r = node.row;
                int c = node.col;
                if(board[r][c] == 1) continue;
                cBoard[node.dir][r][c] = Math.min(cBoard[node.dir][r][c], node.cost);
                for(int i = 0; i < dr.length; ++i){
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    int fee = 100;
                    if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
                        if((node.dir % 2 == 0 && dr[i] == 0) || (node.dir % 2 == 1 && dc[i] == 0)){
                            fee += 500;
                        }
                        queue.add(new Node(nr, nc, node.cost + fee, i));
                    }
                }
            }
        }
    }
}