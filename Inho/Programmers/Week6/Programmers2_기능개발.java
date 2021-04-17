package Algorithm.Basic.Queue;
import java.util.ArrayList;

class Solution2 {
    public static void main(String[] args) {
        int [] pro = {95, 90, 99, 99, 80, 99};
        int [] space = {1, 1, 1, 1, 1, 1};
        int []  answer = solution(pro, space);
        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }

    }
    static public int [] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int current = 0;
        while(current < progresses.length){
            int count = 0;
            boolean stream = true;
            for(int i=current; i<progresses.length; i++){
                progresses[i] += speeds[i];
                if(stream && progresses[i] >= 100){
                    count++;
                    current = i + 1;
                }else{
                    stream = false;
                }
            }
            if(count > 0){
                answer.add(count);
            }
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }

    // 왜안돼냐 이거는,, 시간복잡도 줄여주는거니까 다시해보기
    
    // static public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
    //     ArrayList<Integer> answer = new ArrayList<>();
    //     int current = 0;
    //     int memo = -1;
    //     while(current < progresses.length){
    //         int count = 0;
    //         boolean stream = true;
    //         int multTime =(int)Math.ceil(100-progresses[current]/speeds[current]);
    //         for(int i=current; i<progresses.length; i++){
    //             progresses[i] += speeds[i] * multTime;
    //             if(stream && progresses [i] >= 100){
    //                 memo = i;
    //                 count++;
    //             }else{
    //                 stream = false;
    //             }
    //         }

    //         current = memo+1;
    //         answer.add(count);
           
    //     }
        
    //     return answer;
    // }
}