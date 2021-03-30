package Study_Algorithm_Team_2.Inho.BOJ.Week4;

import java.util.*;
import java.io.*;
class Boj10816{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){ 
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        int [] result = new int [m];
         st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++){
            result[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=0; i<m; i++){
            bw.write(binarySearch(arr, result[i])+ " ");
        }

        bw.write("\n");
        br.close();
        bw.flush();
        bw.close();
    }
    public static int binarySearch(int [] arr, int n){
        int a = findLower(arr, n);
        int b = findUpper(arr, n);
        return b-a;

    }
    public static int findLower(int [] arr, int n){
        int start = 0;
        int end = arr.length ;
        int mid = 0;
        while(start < end){
            mid = (start + end) / 2;
            int midValue =  arr[mid];
            if(midValue < n){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    public static int findUpper (int [] arr, int n){
         int start = 0;
        int end = arr.length ;
        int mid = 0;
        while(start < end){
            mid = (start + end) / 2;
            int midValue =  arr[mid];
            if(midValue <= n){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;

    }
}