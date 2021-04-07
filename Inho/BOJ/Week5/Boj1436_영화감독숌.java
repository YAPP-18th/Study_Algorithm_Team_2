package Study_Algorithm_Team_2.Inho.BOJ.Week5;

import java.io.*;
class Boj1436{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 665;
        while(true){
            i++;
            if(calculate(i)){
                count++;
                if(count == n){
                    break;
                }
            }
        }  
        bw.write(i+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
    public static boolean calculate (int num){
        int count = 0;
        while(num > 0){
            if(num % 10 == 6){
                count++;
                if(count == 3){
                    return true;
                }
            }
            else{
                count = 0;
            }
            num /= 10;
        }
        return false;
    }
}
