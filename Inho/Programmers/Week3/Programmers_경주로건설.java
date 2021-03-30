
import java.util.*;
class Prog_1 {
    public static void main(String[] args){
        int [][] map = {{0,0,0},{0,0,0},{0,0,0}};
        int [][] map2 = {{0,0,1,0},{0,0,0,0},{0,1,0,1}, {1, 0 ,0,0}};
        int [][] map3 = {{0, 0, 1, 0, 1, 1, 0, 0, 0, 0},{0,0,0,0},{0,1,0,1}, {1, 0 ,0,0}};
        
        System.out.println(solution(map2));
    }
    public static int solution(int[][] board) {
        int n = board.length;
        
        int [] dx = {0, 1, 0, -1};
        int [] dy = {1, 0, -1, 0};
        
        Queue<int []> queue = new LinkedList<int []>();
        int [] start = {0, 0, -1, 0};
        queue.offer(start);
        
        while(!queue.isEmpty()){
            int [] tmp = queue.poll();
            int x = tmp[0];
            int y = tmp[1];
            int dir = tmp[2];
            int cost = tmp[3];
            
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1){
                    continue;
                }
                //내가 계산된 값이 뻗어나갈 그 곳의 기존 값보다 작으면 추가
            
                int newCost = cost;
                if(dir == i || dir == -1){
                    newCost += 100;
                }else{
                    newCost += 600;
                }
                if(board[nx][ny] == 0 || newCost <= board[nx][ny]){
                    board[nx][ny] = newCost;
                    queue.offer(new int [] {nx, ny, i, newCost});
                }
                
                
            }
        }
        
        return board[n-1][n-1];
    }
}
