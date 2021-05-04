import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> arr = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i=0; i<record.length; i++){
            String[] userState = record[i].split(" ");
            if(userState[0].equals("Enter")){
                arr.add(userState[1]+"님이 들어왔습니다.");
                map.put(userState[1], userState[2]);
            }else if(userState[0].equals("Leave")){
                arr.add(userState[1]+"님이 나갔습니다.");
            }else if(userState[0].equals("Change")){
                map.put(userState[1], userState[2]);
            }
            
        }
        
        String[] answer = new String[arr.size()];
        
        for(int i=0; i<arr.size(); i++){
            int nicknameIndex = arr.get(i).indexOf("님");
            answer[i] = map.get(arr.get(i).substring(0, nicknameIndex)) + "님이 " + arr.get(i).substring(nicknameIndex + 3);
        }
        
        return answer;
    }
}
