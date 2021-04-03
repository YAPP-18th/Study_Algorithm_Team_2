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

    public static int binarySearch(int []arr, int m){
        int start = 0;
        int end = arr[arr.length-1];
        int mid = (start + end) / 2;;

        int result = 0;
        while(start < end){
            mid = (start + end) / 2;
            if(calculate(arr, mid) >= m){
                result = mid;
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return result;
    }

    public static long calculate(int [] arr, int n){
        long result = 0;
        for(int i: arr){
            if(i > n){
                result += (i-n);
            }
        }
        return result;
    }
}


