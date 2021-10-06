class Solution {
    public int solution(String word) {
        char[] dictionary = {'A', 'E', 'I', 'O', 'U'};
        int order = 781; // (((5 + 1) * 5 + 1) * 5 + 1) * 5 + 1
        int answer = 0;
        
        for(int i=0; i<word.length(); i++){
            for(int j=0; j<5; j++){
                if(dictionary[j] == word.charAt(i)){
                    answer += j * order + 1;
                }
            }
            order = (order - 1) / 5;
        }
        
        return answer;
    }
}
