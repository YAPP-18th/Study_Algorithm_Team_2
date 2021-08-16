import java.util.*;

class Solution {
    public static ArrayList<Integer> indexList = new ArrayList<>();
    public int[] solution(String msg) {
        HashMap<String, Integer> dictionary = new HashMap<>();

        char alphabet = 'A';

        for(int i=0; i<26; i++){
            dictionary.put(String.valueOf(alphabet), i+1);
            alphabet++;
        }

        LZW(msg, dictionary);

        return indexList.stream().mapToInt(integer -> integer).toArray();
    }

    public void LZW(String msg, HashMap<String, Integer> map){
        StringBuilder word = new StringBuilder();
        for(int i=0; i<msg.length(); i++){
            word.append(msg.charAt(i));

            if(!map.containsKey(word.toString())){
                map.put(word.toString(), map.size()+1);
                word.deleteCharAt(word.length()-1);
                indexList.add(map.get(word.toString()));
                LZW(msg.substring(word.length()), map);
                return;
            }else{
                if(i == msg.length()-1){
                    indexList.add(map.get(word.toString()));
                }
            }
        }
    }
}
