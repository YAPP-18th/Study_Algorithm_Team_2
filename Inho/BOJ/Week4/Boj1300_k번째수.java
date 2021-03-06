package Study_Algorithm_Team_2.Inho.BOJ.Week4;

import java.util.*;
import java.io.*;
class boj1300{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        int mid = 0;
        int result = 0;
        while(start <= end){
            mid = (start + end) / 2;
            if(find(mid, n) >= k){
                end = mid - 1;
                result = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        bw.write(result+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
    public static int find(int mid, int n){
        int count = 0;
       for(int i=1; i<= n; i++){
            count += Math.min(mid / i, n);
       }
       return count;
    }
}