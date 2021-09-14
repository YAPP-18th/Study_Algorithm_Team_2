import java.util.*;

class Solution {
    public static char[][] map = new char[5][5];
    public static boolean[][] visited;
    public static boolean result;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];

        for (int i = 0; i < 5; i++) {
            visited = new boolean[5][5];
            result = false;
            answer[i] = 1;

            for (int j = 0; j < 5; j++) {
                map[j] = places[i][j].toCharArray();
            }

            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (map[x][y] != 'P') continue;
                    bfs(x, y);

                    if(result) {
                        answer[i] = 0;
                        break;
                    }
                }
            }
        }

        return answer;
    }
    
    public static void bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<4; i++){
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];
                int distance = Math.abs(x - cx) + Math.abs(y - cy);

                if (cx < 0 || cx >= 5 || cy < 0 || cy >= 5) continue;
                if(visited[cx][cy] || distance > 2) continue;

                visited[cx][cy] = true;

                if (map[cx][cy] == 'X') continue;
                else if(map[cx][cy] == 'P') {
                    result = true;
                    break;
                }
                
                q.offer(new Node(cx, cy));
            }
        }
    }
}

class Node{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
