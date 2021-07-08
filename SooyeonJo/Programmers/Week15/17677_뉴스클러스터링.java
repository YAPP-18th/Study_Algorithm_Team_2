import java.util.*;

class Solution {
    public static ArrayList<String> multiSet1 = new ArrayList<>();
    public static ArrayList<String> multiSet2 = new ArrayList<>();
    
    public int solution(String str1, String str2) {
        getMultiSet(str1.toLowerCase(), str2.toLowerCase());
        
        float jaccard = (float) getIntersection(multiSet1, multiSet2) / getUnion(multiSet1, multiSet2);
        
        return (int) (jaccard * 65536);
    }
    
    public void getMultiSet(String str1, String str2){
        for(int i=0; i<str1.length()-1; i++){
            if(str1.charAt(i) >= 'a' && str1.charAt(i) <= 'z' && str1.charAt(i+1) >= 'a' && str1.charAt(i+1) <= 'z'){
                multiSet1.add(str1.substring(i, i+2));
            }
        }
        
        for(int i=0; i<str2.length()-1; i++){
            if(str2.charAt(i) >= 'a' && str2.charAt(i) <= 'z' && str2.charAt(i+1) >= 'a' && str2.charAt(i+1) <= 'z'){
                multiSet2.add(str2.substring(i, i+2));
            }
        }
    }
    
    public int getIntersection(ArrayList<String> arr1, ArrayList<String> arr2){
        if(arr1.size() == 0 && arr2.size() == 0){
            return 1;
        }
        
        ArrayList<String> temp = new ArrayList<>(arr2);
        int count = 0;
        
        for(int i=0; i<arr1.size(); i++){
            for(int j=0; j<temp.size(); j++){
                if(!arr1.get(i).equals(temp.get(j))) continue;
                temp.remove(j);
                count++;
                break;
            }
        }
        
        return count;
    }
    
    public int getUnion(ArrayList<String> arr1, ArrayList<String> arr2){
        if(arr1.size() == 0 && arr2.size() == 0){
            return 1;
        }
        
        ArrayList<String> temp = new ArrayList<>(arr1);
        int count = 0;
        
        for(int i=0; i<arr2.size(); i++){
            temp.remove(arr2.get(i));
            count++;
        }
        
        count += temp.size();
        
        return count;
    }
}
