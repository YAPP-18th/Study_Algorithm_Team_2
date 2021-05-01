import java.util.*;
class lskdjf{
    public static void main(String[] args){
        
    }
    static boolean [] isPrime;
    static String [] strArr;
    static boolean [] visit;
    static int answer;
    public int solution(String numbers) {
        answer = 0;
        
        isPrime = new boolean [10000000];
        for(int i=2; i<10000000; i++){
            isPrime[i] = true;
        }
        for(int i=2; i<Math.sqrt(10000000); i++){
            if(isPrime[i] == false){
                continue;
            }
            for(int j=i+i; j<10000000; j+=i){
                isPrime[j] = false;
            }
        }
        
        strArr = numbers.split("");
        for(int i=1; i<= strArr.length; i++){
            visit = new boolean [strArr.length];
            recursive("", 0, i);
        }
        
        return answer;
    }
    public void recursive(String tmp, int count, int limit){
        if(count == limit){
            if(isPrime[Integer.parseInt(tmp)]){
                answer++;
                isPrime[Integer.parseInt(tmp)] = false;
            }
        }
        for(int i=0; i<strArr.length; i++){
            if(!visit[i]){
                visit[i] = true;
                tmp += strArr[i];
                recursive(tmp, count+1, limit);
                visit[i] = false;
                tmp = tmp.substring(0, tmp.length()-1);
            }
        }
    }
}