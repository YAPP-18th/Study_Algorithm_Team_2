class Solution { 
    boolean[][] visited;
    int[][] metrics;
    int area = 0;
    int cnt = 0;
    int[] x_arr = {1,0,-1,0};
    int[] y_arr = {0,1,0,-1};

    
    public int[] solution(int m, int n, int[][] picture) {
        int maxSizeOfOneArea = 0;
        
        metrics = picture;
        visited = new boolean[picture.length][picture[0].length];
        
        for(int i = 0; i < picture.length; i ++) {
            for(int j = 0; j < picture[0].length; j ++) {
                if (metrics[i][j] != 0 && !visited[i][j]) {
                    cnt = 0;
                    area ++;
                    dfs(i,j,metrics[i][j]);
                    if(cnt > maxSizeOfOneArea) maxSizeOfOneArea = cnt;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = area;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
    private void dfs(int x, int y, int color) {
        visited[x][y] = true;
        cnt ++;
        
        for(int i = 0; i < 4; i ++) {
            int new_x = x + x_arr[i];
            int new_y = y + y_arr[i];
            
            if(isValid(new_x, new_y, color)) {
                dfs(new_x, new_y, color);
            }
        }
    }
    
    private boolean isValid(int x, int y, int color) {
        if(x >= metrics.length || x < 0) return false;
        if(y >= metrics[0].length || y < 0) return false;
        if(metrics[x][y] == 0 || metrics[x][y] != color) return false;
        if(visited[x][y]) return false;
        
        return true;
    }
}
