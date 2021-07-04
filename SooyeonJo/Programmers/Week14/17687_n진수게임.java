class Solution {
    public String solution(int n, int t, int m, int p){
        StringBuilder answer = new StringBuilder();
        String temp = convert(n, t*m);

        for(int i=0; i<t; i++){
            answer.append(temp.charAt((m*i)+p-1));
        }

        return answer.toString();
    }

    public String convert(int n, int length){
        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        result.append(0);
        int temp = 1;

        for(int i=1; i<length; i++){
            while(temp > 0){
                if(temp % n < 10){
                    sb.append(temp % n);
                }else{
                    sb.append((char)(temp % n - 10 + 'A'));
                }
                temp /= n;
            }
            temp = i+1;
            result.append(sb.reverse());
            sb = new StringBuilder();
        }

        return result.toString();
    }
    
}
