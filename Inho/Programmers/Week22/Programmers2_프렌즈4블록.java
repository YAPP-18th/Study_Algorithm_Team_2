import java.util.*;
class Solution {
    static char [][] map;
    static boolean [][] visit;
    static int M;
    static int N;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        map = new char [m][n];
        M = m;
        N = n;
        // 맵 표시
        for(int i=0; i<m; i++){
            char [] arr = board[i].toCharArray();
            for(int j=0; j<n; j++){
                map[i][j] = arr[j];
            }
        }
        // System.out.println(popBlock());
        while(true){
            boolean flag = check();
            if(!flag) break;
            answer += popBlock();
        }
        return answer;
    }
    
    public boolean check(){
        boolean flag = false;
        visit = new boolean [M][N];
        for(int i=0; i<M-1; i++){
            for(int j=0; j<N-1; j++){
                if(Character.isAlphabetic(map[i][j]) && map[i][j] == map[i][j+1] && map[i][j] == map[i+1][j] && map[i][j] == map[i+1][j+1]){
                    flag = true;
                    visit[i][j] = true;
                    visit[i][j+1] = true;
                    visit[i+1][j] = true;
                    visit[i+1][j+1] = true;
                }
            }
        }
        
        return flag;
    }
    public int popBlock(){
       
        int count = 0;
        char [][] newMap = new char [M][N];
        
        for(int j=0; j<N; j++){
            int idx = M-1;
            for(int i=M-1; i>=0; i--){
                if(!visit[i][j]){
                    newMap[idx][j] = map[i][j];
                    idx--;
                }else{
                    count++;
                }
            }
        }
        map = newMap;
        return count;
    }
}