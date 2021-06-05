class Solution {
    public int[] solution(int n) {
        int max = n*(n+1)/2;
        int[] answer = new int[max];
        int[][] arr = new int[n][n];
        
        int i=0, j=0, k=1;
        arr[0][0] = 1;
        
        while(k < max){
            while(i+1 < n && arr[i+1][j] == 0){
                arr[++i][j] = ++k;
            }
            
            while(j+1 < n && arr[i][j+1] == 0){
                arr[i][++j] = ++k;
            }
            
            while(i-1 > 0 && arr[i-1][j-1] == 0){
                arr[--i][--j] = ++k;
            }
        }
        
        k = 0;
        
        for(i=0; i<n; i++){
            for(j=0; j<=i; j++){
                answer[k++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
