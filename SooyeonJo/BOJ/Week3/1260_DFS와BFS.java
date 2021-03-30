import java.util.*;

public class Main{
    public static int n, m, v;
    public static boolean[] visited = new boolean[1001];
    public static int[][] graph = new int[1001][1001];

    public static void dfs(int start){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i=1; i<graph.length; i++){
            if(!visited[i] && graph[start][i] == 1){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int x = q.poll();
            System.out.print(x + " ");

            for(int i=1; i<graph.length; i++){
                if(!visited[i] && graph[x][i] == 1){
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();

        for(int i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        dfs(v);
        System.out.println();
        visited = new boolean[1001];
        bfs(v);
    }
}
