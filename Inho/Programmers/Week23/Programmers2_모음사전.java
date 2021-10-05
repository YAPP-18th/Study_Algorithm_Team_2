class Solution {
    
    // 수학적인 규칙이 있는지
    // 모든 경우를 다 구하고, 몇번째인지 찾아내서 출력하는지
    static int subsequence = 0;
    static String correct;
    static int ans;
    public int solution(String word) {
        correct = change(word);
        dfs("", 0);
        return ans;
    }
    
    public void dfs(String Str, int len){
        
        if(len > 5){
            return;
        }
        if(Str.equals(correct)){
            ans = subsequence;
        }
        subsequence++;
        
        for(int i=1; i<=5; i++){
            dfs(Str+String.valueOf(i), len+1);
        }
        
    }
    
    public String change (String str){
        char [] arr = str.toCharArray();
        String answer = "";
        for(int i=0; i<arr.length; i++){
            switch(arr[i]){
                case 'A':
                    answer += '1';
                    break;
                case 'E':
                    answer += '2';
                    break;
                case 'I':
                    answer += '3';
                    break;
                case 'O':
                    answer += '4';
                    break;
                case 'U':
                    answer += '5';
                    break;
            }
        }
        return answer;
    }
}