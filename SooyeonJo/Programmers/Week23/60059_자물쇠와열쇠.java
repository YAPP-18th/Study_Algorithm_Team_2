class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int[][] newLock = new int[n * 3][n * 3];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                newLock[i + n][j + n] = lock[i][j];
            }
        }
        
        for(int rotation=0; rotation<4; rotation++){
            key = rotate(key);
            for(int x=0; x<n*2; x++){
                for(int y=0; y<n*2; y++){
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            newLock[x+i][y+j] += key[i][j];
                        }
                    }
                    
                    if(check(newLock)) return true;
                    
                    for(int i=0; i<m; i++){
                        for(int j=0; j<m; j++){
                            newLock[x+i][y+j] -= key[i][j];
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    public int[][] rotate(int[][] arr){
        int n = arr.length;
        int[][] result = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                result[j][n-i-1] = arr[i][j];
            }
        }
        
        return result;
    }
    
    public boolean check(int[][] arr){
        int length = arr.length / 3;
        
        for(int i=length; i<length*2; i++){
            for(int j=length; j<length*2; j++){
                if(arr[i][j] == 1) continue;
                return false;
            }
        }
        
        return true;
    }
}
