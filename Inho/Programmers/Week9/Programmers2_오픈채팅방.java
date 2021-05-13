import java.util.ArrayList;
import java.util.HashMap;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<String,String>();
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        for(String r: record){
            String [] arr = r.split(" ");
            if(arr[0].equals("Enter")){
                hm.put(arr[1], arr[2]); // 이거맞나
                list.add(new String [] {"0", arr[1]});
            }else if(arr[0].equals("Leave")){
                list.add(new String[] {"1", arr[1]});
            }else{
                hm.put(arr[1], arr[2]);
            }
        }
        String [] answer = new String [list.size()];
        for(int i=0; i<list.size(); i++){
            String [] tmp = list.get(i); // 이거맞나
            if(tmp[0].equals("0")){
                answer[i] = hm.get(tmp[1])+ "님이 들어왔습니다.";
            }else if(tmp[0].equals("1")){
                answer[i] = hm.get(tmp[1]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}