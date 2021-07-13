import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> str1_ss = getSubstringList(str1);
        ArrayList<String> str2_ss = getSubstringList(str2);
        ArrayList<String> union = new ArrayList<>();
        ArrayList<String> duple = new ArrayList<>();
        
        System.out.print(str2_ss);
        
        int size = str1_ss.size() + str2_ss.size();
        
        if(size == 0) return 65536;
        
        for(String ss : str1_ss) {
            if(str2_ss.remove(ss)) {
                duple.add(ss);
            }
            union.add(ss);
        }
        
        for(String ss : str2_ss) {
            union.add(ss);
        }
        
        double zakad = duple.size() / (double)union.size();
        
        int answer = (int)(zakad * 65536);
        return answer;
    }
    
    private ArrayList<String> getSubstringList(String str) {
        ArrayList<String> substringList = new ArrayList<>();
        
        for(int idx = 0; idx < str.length() - 1; idx ++) {
            String ss = str.substring(idx, idx + 2).toLowerCase();
            if(isValid(ss)) substringList.add(ss);
        }
        
        return substringList;
    }
    
    private boolean isValid(String substring) {
        String check = substring.replaceAll("[^a-z]", "");
        
        return check.equals(substring);
    }
}
