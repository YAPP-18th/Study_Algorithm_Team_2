class Solution {
    public static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    public static boolean[] visited;
    public static int answer;
    public int solution(int n, String[] data) {
        answer = 0;
        visited = new boolean[8];
        
        permutation("", data);
        
        return answer;
    }
    
    public void permutation(String s, String[] data){
        if(s.length() == 8){
            if(check(s, data)){
                answer++;
            }
            return;
        }
        
        for(int i=0; i<8; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation(s+friends[i], data);
                visited[i] = false;
            }
        }
    }
    
    public boolean check(String s, String[] data){
        for(int i=0; i<data.length; i++){
            int cx = s.indexOf(data[i].charAt(0));
            int cy = s.indexOf(data[i].charAt(2));
            char operator = data[i].charAt(3);
            int condition = data[i].charAt(4) - '0';
            
            if(operator == '='){
                if(!(Math.abs(cx - cy) == condition + 1)) return false;
            }else if(operator == '>'){
                if(!(Math.abs(cx - cy) > condition + 1)) return false;
            }else if(operator == '<'){
                if(!(Math.abs(cx - cy) < condition + 1)) return false;
            }
        }
        return true;
    }
}
