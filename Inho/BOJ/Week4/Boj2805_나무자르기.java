package Study_Algorithm_Team_2.Inho.BOJ.Week4;

import java.util.*;
import java.io.*;
class Boj2805{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int [n];
        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        bw.write(binarySearch(arr, m) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    public static long binarySearch(int []arr, int m){
        long start = 0;
        long end = arr[arr.length-1];
        long mid = (start + end) / 2;;

        while(start <= end){ 
            mid = (start + end) / 2;
            // 가능한 최소 경계를 찾아야함.
            if(calculate(arr, mid) >= m){
                start = mid + 1 ;
            }else{
                end = mid - 1;
            }
        }
        return end;
    }

    public static long calculate(int [] arr, long n){
        long result = 0;
        for(int i: arr){
            if(i > n){
                result += (i-n);
            }
        }
        return result;
    }
}


