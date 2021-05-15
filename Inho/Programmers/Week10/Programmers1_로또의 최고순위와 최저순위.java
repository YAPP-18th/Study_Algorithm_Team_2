import java.util.HashSet;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int min = 1;
        int max = 6;
        boolean once = false;
        HashSet <Integer> hs = new HashSet<Integer>();
        for(int i: win_nums){
            hs.add(i);
        }
        for(int i: lottos){
            if(i == 0){
                continue;
            }
            if(hs.contains(i) ){
                if(once){
               max--;
                                        
                }else{
                    once = true;
                }
            }else{
                min++;
            }
         
        }
        if(min > 6){
            min--;
        }
        return new int [] {min, max};
    }
}