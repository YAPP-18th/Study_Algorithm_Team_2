import java.util.*;

class Solution {
    static final int MAX_VALUE = 99999999;
    int[][] metrics;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        metrics = new int[n + 1][n + 1];
        
        // 초기화
        for (int i = 0; i <= n; i++) {
            Arrays.fill(metrics[i], MAX_VALUE);
            metrics[i][i] = 0;
        }

        // fare 값 입력
        for(int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int end = fares[i][1];
            int cost = fares[i][2];

            metrics[start][end] = cost;
            metrics[end][start] = cost;
        }

        // 플로이드 마샬
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    metrics[i][j] = Math.min(metrics[i][j], metrics[i][k] + metrics[k][j]);
                }
            }
        }


        // 각자 가는 경우로 초기화
        int answer = metrics[s][a] + metrics[s][b];

        // 탐색하면서 경유하면서 갈 경우 이득보는 부분을 찾는다.
        for(int i = 1; i <= n; i++) {
            answer = Math.min(answer, metrics[s][i] + metrics[i][a] + metrics[i][b]);
        }
        
        return answer;
    }
}
