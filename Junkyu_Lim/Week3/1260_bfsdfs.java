import java.util.*;
import java.io.*;

public class bfsdfs {
    public static boolean[] visited;
    public static boolean[][] graph;
    public static StringJoiner sj;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt( st.nextToken());
        int V = Integer.parseInt( st.nextToken());

        visited = new boolean[N+1];
        graph = new boolean[N+1][N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt( st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        sj = new StringJoiner(" ");
        DFS(V);
        System.out.println(sj.toString());

        sj = new StringJoiner(" ");
        visited = new boolean[N+1];
        BFS(V);
        System.out.println(sj.toString());
    }

    private static void DFS(int start){
        visited[start] = true;
        sj.add(Integer.toString(start));
        for(int i = 1; i < graph.length; i++){
            if(!visited[i] && graph[start][i]) DFS(i);
        }
    }

    private static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;

        while(!que.isEmpty()){
            int target = que.poll();
            sj.add(Integer.toString(target));
            for(int i = 1; i < graph.length; i++){
                if(!visited[i] && graph[target][i]){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
