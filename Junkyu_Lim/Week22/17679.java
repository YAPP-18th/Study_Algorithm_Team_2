class Solution {
    boolean[][] check;
    String[][] map;
    int M, N;
    
    public int solution(int m, int n, String[] board) {
        boolean flag = true;
        int answer = 0;
        map = new String[m][n];
        M = m;
        N = n;
        
        for (int i = 0; i < m; i ++) {
            String[] str = board[i].split("");
            for (int j = 0; j < n; j ++) {
                map[i][j] = str[j];
            }
        }
        
        while(flag) {
            flag = isPop();
            answer += popNDown();
        }
        
        return answer;
    }
    
    public boolean isPop() {
        boolean isPopped = false;
        
        check = new boolean [M][N];
        
        for(int i = 0; i < M - 1; i ++) {
            for(int j = 0; j < N - 1; j ++) {
                if(!map[i][j].equals("-") && 
                   map[i][j].equals(map[i][j+1]) && 
                   map[i][j].equals(map[i+1][j]) && 
                   map[i][j].equals(map[i+1][j+1])
                  ){
                    isPopped = true;
                    check[i][j] = true;
                    check[i][j+1] = true;
                    check[i+1][j] = true;
                    check[i+1][j+1] = true;
                }
            }
        }

        return isPopped;
    }
    
    public int popNDown(){
        String[][] nMap = new String[M][N];
        int yIndex, popCount = 0;
        
        for(int x = 0; x < N; x ++) {
            yIndex = M - 1;
            
            for (int y = M - 1; y >= 0; y --) {
                if (!check[y][x]) {
                    nMap[yIndex][x] = map[y][x];
                    yIndex --;
                } else
                    popCount ++;
            }
            
            while(yIndex >= 0) {
                nMap[yIndex][x] = "-";
                yIndex --;
            }
        }
        
        map = nMap;

        return popCount;
    }
}
