import java.util.*;

public class Main{
    public static int t;
    public static int m, n, k;
    public static int count;
    public static boolean[][] visited;
    public static int[][] map;
    //동남서북
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void bfs(int x, int y){
        Queue<Position> q = new LinkedList<>();
        q.offer(new Position(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Position position = q.poll();
            for(int i=0; i<4; i++){
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];
                if(cx >= 0 && cy >= 0 && cx < n && cy < m){
                    if(!visited[cx][cy] && map[cx][cy] == 1){
                        q.offer(new Position(cx, cy));
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();

        for(int testCase=0; testCase<t; testCase++){
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            count = 0;
            visited = new boolean[n][m];
            map = new int[n][m];

            for(int i=0; i<k; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[y][x] = 1;
            }

            if(k == 1){
                System.out.println(1);
            }else{
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(!visited[i][j] && map[i][j] == 1){
                            bfs(i, j);
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }

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
