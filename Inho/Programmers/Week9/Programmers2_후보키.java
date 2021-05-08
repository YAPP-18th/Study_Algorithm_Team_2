import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
class Solution {
    String [][] relation;
    boolean [] visited;
    ArrayList<boolean []>candidates;
    int answer;
    public int solution(String[][] relation) {
        candidates = new ArrayList<boolean[]>();
        visited = new boolean [relation[0].length];
        this.relation = relation;
        answer = 0;
        for(int i=1; i<=relation[0].length; i++){
            dfs(0, 0, i );
        }
        return answer;
    }
    public void dfs(int count, int start, int limit){
        if(count == limit){
            isUnique();
            return;
        }
        
        for(int i = start; i< relation[0].length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(count +1, i+1, limit);
                visited[i] = false;
            }
        }
    }
    public void isUnique () {
        HashSet<String> hs = new HashSet<String>();
        for(int i=0; i<relation.length; i++){
            String tmp = "";
            for(int j=0; j< visited.length; j++){
                if(visited[j]){
                    tmp+= relation[i][j];
                }
            }
            if(hs.contains(tmp)){
                return;
            }else{
                hs.add(tmp);
            }
        }
        if(isMin()){
            candidates.add(visited.clone());
            answer++;
        }
        
    }
    public boolean isMin(){
      
        for(int i=0; i<candidates.size(); i++){
            if(!masking(i)){
                return false;
            }
        }
        return true;
    }
    public boolean masking (int index){
        boolean [] tmp = candidates.get(index); 
        boolean [] masking = new boolean[visited.length];
        
        for(int j=0; j<tmp.length; j++){
            if(visited[j] && tmp[j]){
                masking[j] = true;
            }
        }
           
        for(int j=0; j<tmp.length; j++){
            if(masking[j] != tmp[j]){
                return true;
            }
        }
        return false;
    }
}