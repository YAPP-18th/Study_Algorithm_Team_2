import java.util.*;

public class Main{
    public static int t;
    public static int m, n, k;
    public static int count;
    public static boolean[][] visited;
    public static int[][] map;
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int cx = x + dx[i];
            int cy = y + dy[i];

            if(cx >= 0 && cy >= 0 && cx < n && cy < m){
                if(!visited[cx][cy] && map[cx][cy] == 1){
                    dfs(cx, cy);
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
                            dfs(i, j);
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }

    }
}
