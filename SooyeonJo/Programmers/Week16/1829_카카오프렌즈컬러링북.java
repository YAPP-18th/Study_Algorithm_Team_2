import java.util.*;

class Solution {
    public static boolean visited[][];
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] == 0 || visited[i][j]) continue;
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, picture));
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    public int bfs(int x, int y, int m, int n, int[][] map){
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        visited[x][y] = true;
        
        int count = 1;
        
        while(!q.isEmpty()){
            Position position = q.poll();
            for(int i=0; i<4; i++){
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];
                if(cx >= 0 && cx < m && cy >= 0 && cy < n){
                    if(visited[cx][cy] || map[cx][cy] - map[position.x][position.y] != 0) continue;
                    q.offer(new Position(cx, cy));
                    visited[cx][cy] = true;
                    count++;
                }
            }
        }
        
        return count;
    }
}

class Position{
    int x;
    int y;
    
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}
