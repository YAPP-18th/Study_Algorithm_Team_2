import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                String head1 = s1.split("[0-9]")[0];
                String head2 = s2.split("[0-9]")[0];
                
                int result = head1.toLowerCase().compareTo(head2.toLowerCase());
                if(result == 0){
                    return findNum(s1) - findNum(s2);
                }
                return result;
            }
        });
        return files;
    }
    public int findNum(String str){
        char [] arr = str.toCharArray();
        String answer = "";
        boolean flag = false;
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(Character.isDigit(c) && answer.length() < 5){
                flag = true;
                answer += c;
            }else{
                if(flag){
                    break;
                }
            }
        }
        return Integer.parseInt(answer);
    }
}