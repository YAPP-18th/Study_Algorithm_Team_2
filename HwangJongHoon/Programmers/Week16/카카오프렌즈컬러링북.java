package Programmers.YAPP.Week16;

import java.util.HashMap;
import java.util.Map;

public class 카카오프렌즈컬러링북 {
    static class Solution {
        boolean[][] visited;
        boolean[][] tVisited;
        int M, N;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int cnt;
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        public int[] solution(int m, int n, int[][] picture) {
            M = m;
            N = n;
            // 방문 배열 초기화
            visited = new boolean[m][n];
            tVisited = new boolean[m][n];

            dfs(picture, 0, 0);

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            return answer;
        }

        public void dfs(int[][] picture, int r, int c){
            // 인덱스 경계값 검사
            if(r < 0 || r >= M || c < 0 || c >= N) return;
            //방문 여부 검사
            if(visited[r][c]) return;
            visited[r][c] = true;
            if(picture[r][c] != 0) { // 현재 위치가 컬러링 된 부분이라면
                cnt = 0;
                int target = picture[r][c]; // 목표 선정
                targetDfs(picture, target, r, c);
                if(cnt > 0){
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
            for(int i = 0; i < 4; ++i){
                int nr = r + dr[i];
                int nc = c + dc[i];
                dfs(picture, nr, nc);
            }
        }

        public void targetDfs(int[][] picture, int target, int r, int c){
            if(r < 0 || r >= M || c < 0 || c >= N) return;
            if(tVisited[r][c]) return;
            if(picture[r][c] != target) return;
            tVisited[r][c] = true;
            cnt++;
            for(int i = 0; i < 4; ++i){
                int nr = r + dr[i];
                int nc = c + dc[i];
                targetDfs(picture, target, nr, nc);
            }
        }
    }
}
