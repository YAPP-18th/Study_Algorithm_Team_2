import java.util.*;
import java.io.*;
class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        int [][][] cost = new int [n][n][4];
        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, -1, 0, 1};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<4; k++){
                    cost[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }
        
        
        Queue<int []> queue = new LinkedList<int []>();
        int [] start = {0, 0, -1, 0};
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int [] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int dir = tmp[2];
            int sum = tmp[3];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1){
                    continue;
                }
                //내가 계산된 값이 뻗어나갈 그 곳의 기존 값보다 작으면 추가
                int newCost = sum;
                if(dir == i || dir == -1){
                    newCost += 100;
                }else{
                    newCost += 600;
                }
                if(newCost <= cost[nx][ny][i]){
                    cost[nx][ny][i] = newCost;
                    queue.offer(new int [] {nx, ny, i, newCost});
                }
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int i=0; i<4; i++){
            answer = Math.min(answer, cost[n-1][n-1][i]);
        }
        return answer;
    }
}