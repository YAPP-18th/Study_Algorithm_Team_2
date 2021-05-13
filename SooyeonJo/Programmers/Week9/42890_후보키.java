import java.util.*;

class Solution {
    ArrayList<HashSet<Integer>> candidateKey = new ArrayList<>();
    
    public int solution(String[][] relation) {
        for(int i=1; i<=relation[0].length; i++){
            combination(0, 0, i, relation[0].length, new HashSet<>(), relation);
        }
        return candidateKey.size();
    }
    
    public void combination(int idx, int start, int size, int n, HashSet<Integer> keys, String[][] relation){
        if(idx == size){
            for(HashSet<Integer> key : candidateKey){
                if(keys.containsAll(key)) return;
            }
            
            if(isUnique(keys, relation)){
                candidateKey.add(keys);
            }
            
            return;
        }
        
        for(int i=start; i<n; i++){
            HashSet<Integer> selectedKey = new HashSet<>(keys);
            selectedKey.add(i);
            combination(idx+1, i+1, size, n, selectedKey, relation);
        }
    }
    
    public boolean isUnique(HashSet<Integer> keys, String[][] relation){
       HashSet<String> set = new HashSet<>();
        for (String[] tuple : relation) {
            StringBuilder sb = new StringBuilder();
            for (int k : keys) {
                sb.append(tuple[k]);
            }
            if (set.contains(sb.toString())) return false;
            set.add(sb.toString());
        }
        return true;
    }
}
