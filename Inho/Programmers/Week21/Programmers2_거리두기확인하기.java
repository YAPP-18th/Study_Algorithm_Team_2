import java.util.*;
class Solution {
    static char [][] map;
    static boolean [][] visit;
    static boolean result;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    
    public int[] solution(String[][] places) {
        ArrayList<Integer> answer = new ArrayList<Integer>();
        map = new char [5][5];
        
        // i가 맵 한개
        for(int i=0; i<5; i++){
            
            result = false;
            for(int j=0; j<5; j++){
                map[j] = places[i][j].toCharArray();
            }
            
            visit = new boolean [5][5];
            for(int k=0; k<5; k++){
                for(int p=0; p<5; p++){
                    if(map[k][p] == 'P'){
                        visit[k][p] = true;
                        check(k, p, 0);
                    }
                }
            }
            
            if(result){
                answer.add(0);
            }else{
                answer.add(1);
            }
        }
        
        return answer.stream().mapToInt(x->x).toArray();
    }
    public void check(int a, int b, int count){
        if(count == 2){
            return;
        }
        
        for(int i=0; i<4; i++){
            int na = a+ dx[i];
            int nb = b+ dy[i];
            if(na < 0 || nb < 0 || na > 4 || nb > 4 || map[na][nb]=='X' || visit[na][nb]){
                continue;
            }
            if(map[na][nb] == 'P'){
                result = true;
                return;
            }
            visit[na][nb] = true;
            check(na, nb, count + 1);
            visit[na][nb] = false;
        }
    }
    
}