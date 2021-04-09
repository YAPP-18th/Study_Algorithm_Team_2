import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main{
    public static int n;
    public static int[][] map;
    public static boolean[] visited;
    public static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        dfs(0, 0);
        System.out.println(min);
    }
    
    public static void dfs(int index, int count){
        if(count == n / 2){
            calc();
            return;
        }
        
        for(int i=index; i<n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            dfs(i+1, count+1);
            visited[i] = false;
        }
    }
    
    public static void calc(){
        int totalStart = 0;
        int totalLink = 0;
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(visited[i] && visited[j]){
                    totalStart += map[i][j];
                    totalStart += map[j][i];
                }else if(!visited[i] && !visited[j]){
                    totalLink += map[i][j];
                    totalLink += map[j][i];
                }
            }
        }
        
        int total = Math.abs(totalStart - totalLink);
        if(total == 0){
            System.out.println(total);
            System.exit(0);
        }
        
        min = Math.min(total, min);
    }
}
