import java.util.*;

public class Main{
    public static int m, n;
    public static int[][] tomato = new int[1000][1000];
    public static int[] dx = {1, 0, -1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static Queue<Position> q = new LinkedList<>();
    public static int result = 0;

    public static int bfs(){
        while(!q.isEmpty()){
            Position position = q.poll();
            for(int i=0; i<4; i++){
                int cx = position.x + dx[i];
                int cy = position.y + dy[i];

                if(cx >= 0 && cy >= 0 && cx < n && cy < m){
                    if(tomato[cx][cy] == 0){
                        q.offer(new Position(cx, cy));
                        tomato[cx][cy] = tomato[position.x][position.y] + 1;
                    }
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(tomato[i][j] == 0){
                    return -1;
                }
                result = Math.max(result, tomato[i][j]);
            }
        }

        if(result == 1) return 0;
        return result - 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j] == 1){
                    q.offer(new Position(i, j));
                }
            }
        }

        System.out.println(bfs());
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
