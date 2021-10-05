// 효율성 테스트 없음 -> 완탐
// 회전하면 4가지 모양 가능
// 각 모양별로 이동시켜야하는데 어떻게 이동시키지?

// 1. 회전모듈
// 2. 이동모듈
// 3. 검사모듈

// 이후에 가지치기가 필요한지 생각해보기
class Solution {
    static boolean [][] Lock;
    static boolean [][] Key;
    static int holeCnt = 0;
    static int kn;
    static int ln;
    public boolean solution(int[][] key, int[][] lock) {
        
        kn = key.length;
        ln = lock.length;
        Lock = new boolean [ln][ln];
        Key = new boolean [kn][kn];
        
        for(int i=0; i<kn; i++){
            for(int j=0; j<kn; j++){
                if(key[i][j] == 1){
                    Key[i][j] = true;
                }
            }
        }
        
        for(int i=0; i<ln; i++){
            for(int j=0; j<ln; j++){
                if(lock[i][j] == 1){
                    Lock[i][j] = true;
                }else{
                    holeCnt++;                    
                }
            }
        }
        
        for(int k=0; k<4; k++){
            // 이동 검사
            if(moveCheck()) return true;
            rotate();
        }
        // rotate();
        // moveCheck();
        
        return false;
    }
    public boolean moveCheck() {
        for(int i=-kn+1; i<ln; i++){
            for(int j=-kn+1; j<ln; j++){
                if(check(i, j)) return true;
            }
        }
        return false;
//         for(int i=0; i<kn; i++){
//             for(int j=0; j<kn; j++){
//                 System.out.print(Key[i][j]+ " ");
//             }
//                 System.out.println();
            
//         }

//         System.out.println("answer = " + check(1, 1));
//         System.out.println(holeCnt);
            // check(-kn+1, -kn+1);
//         return false;
    }
    
    // a, b는 키가 시작하는 위치
    public boolean check(int a, int b){
        int cnt = holeCnt;
        for(int i=0; i<kn; i++){
            int keyx = i+a;
            if(keyx >= ln) break;
            if(keyx < 0) continue;
            for(int j=0; j<kn; j++){
                int lj = j+b;
                if(lj >= ln ) break;
                if(lj < 0) continue;
                if(Key[i][j] == Lock[i+a][j+b]) return false;
                if(Key[i][j] && !Lock[i+a][j+b]) cnt--;
                
            }
        }
        if(cnt == 0) return true;
        else return false;
    }
    
    
    public void rotate() {
        
        boolean [][] rotate = new boolean [kn][kn];

        for (int i = 0; i < kn; i++) {
            for (int j = 0; j < kn; j++) {
                rotate[i][j] = Key[kn-1-j][i];
            }
        }

        Key = rotate;
    }
}