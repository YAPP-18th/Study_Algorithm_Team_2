class Solution {
    public static char[][] map;
    public static boolean[][] sameCharacter;
    public static int answer;
    public int solution(int m, int n, String[] board) {
        answer = 0;

        map = new char[m][n];

        for(int i=0; i<m; i++){
            map[i] = board[i].toCharArray();
        }

        while(true){
            sameCharacter = new boolean[m][n];
            boolean hasSameBlock = false;

            for(int i=0; i<m-1; i++){
                for(int j=0; j<n-1; j++){
                    if(map[i][j] == '-') continue;
                    if(checkBlock(i, j, map[i][j])){
                        sameCharacter[i][j] = true;
                        sameCharacter[i+1][j] = true;
                        sameCharacter[i][j+1] = true;
                        sameCharacter[i+1][j+1] = true;
                        hasSameBlock = true;
                    }
                }
            }

            if(!hasSameBlock) break;

            deleteBlock(m, n);

            downBlock(m, n);
        }

        return answer;
    }

    public boolean checkBlock(int x, int y, char block){
        return map[x + 1][y] == block && map[x][y + 1] == block && map[x + 1][y + 1] == block;
    }

    public void deleteBlock(int m, int n){
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!sameCharacter[i][j]) continue;
                map[i][j] = '-';
                answer++;
            }
        }
    }

    public void downBlock(int m, int n){
        for(int y=0; y<n; y++){
            int x = m-1;

            while(x >= 0){
                // 맨 아래에서부터 빈 블록 위치 찾기
                if(map[x][y] != '-'){
                    x--;
                    continue;
                }

                // 빈 블록 위에 캐릭터 블록이 있는지 탐색
                int nx = x-1;
                while(nx >= 0){
                    if(map[nx][y] != '-'){
                        map[x][y] = map[nx][y];
                        map[nx][y] = '-';
                        break;
                    }
                    nx--;
                }
                x--;
            }
        }
    }
    
}
