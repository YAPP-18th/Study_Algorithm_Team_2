import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String, Boolean> hm = new HashMap<>();
        HashSet<Integer> sizes = new HashSet<>();
        ArrayList<String> subStrings = new ArrayList<>();
        
        boolean answer = true;

        for(String st:phone_book) {
            hm.put(st, true);
            sizes.add(st.length());
        }
        
        for(int size:sizes) {
            for(String st:phone_book){
                if(st.length() >= size) {
                    String substring = st.substring(0,size);
                    
                    if(hm.get(substring) != null) {
                        if(hm.get(substring)) hm.put(substring, false);
                        else answer = false;
                    }
                }
            }
        }
        
        return answer;
    }
}