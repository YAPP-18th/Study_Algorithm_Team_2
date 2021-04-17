package Algorithm.Basic.Stack;

class Prog2{
    public static void main(String[] args){
        int [] prices = {1, 2, 3, 2, 3};
        int [] tmp = solution(prices);
        for(int i=0; i<tmp.length; i++){
            System.out.println(tmp[i]+"\n");
        }
    }

    static public int[] solution(int[] prices) {
        int[] answer = new int [prices.length];
        for(int i=0; i<prices.length-1; i++){
            for(int j = i+1; j< prices.length; j++){
                if(prices[i] <= prices[j]){
                    answer[i]++;
                }else{
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
