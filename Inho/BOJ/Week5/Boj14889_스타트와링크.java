package Study_Algorithm_Team_2.Inho.BOJ.Week5;

import java.util.*;
import java.io.*;
class Boj14889{
    static int [] arr;
    static int n;
    static int [][] score;
    static boolean [] visit;
    static BufferedWriter bw;
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        score = new int [n+1][n+1];
        visit = new boolean [n+1];
        min = Integer.MAX_VALUE;

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(1, 0);
        bw.write(min+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(int count, int start){
        if(count > n/2){
            calculate();
            return;
        }
    
        for(int i=start+1; i<=n; i++){
            visit[i] = true;
            dfs(count +1, i);
            visit[i] = false;
        }

    }

    public static void calculate(){
        int [] teamA = new int [n/2];
        int [] teamB = new int [n/2];
        int aIndex = 0;
        int bIndex = 0;

        for(int i=1; i<=n; i++){
            if(visit[i]){
                teamA[aIndex++] = i;
            }else{
                teamB[bIndex++] = i;
            }
        }
        
        int resultA = 0;
        int resultB = 0;

        for(int i=0; i<n/2; i++){
            for(int j=0; j<n/2; j++){

                resultA += score[teamA[i]][teamA[j]];
                resultB += score[teamB[i]][teamB[j]];
            }
        }
        min = Math.min(min, Math.abs(resultA - resultB));
    }
}