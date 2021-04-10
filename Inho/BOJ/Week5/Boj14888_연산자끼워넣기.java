package Study_Algorithm_Team_2.Inho.BOJ.Week5;
import java.util.*;
import java.io.*;
class Boj14888{
    static int n;
    static int [] arr;
    static int [] operatorCount;
    static int [] operator;
    static int min;
    static int max;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int [n];
        operatorCount = new int [4];
        operator = new int [n -1];
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operatorCount[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        bw.write(max +"\n");
        bw.write(min + "\n");
        br.close();
        bw.flush();
        bw.close();
    }
    public static void dfs(int count) throws IOException{
        if(count == n-1){
            int result = calculate();
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }
        for(int i=0; i<4; i++){
            if(operatorCount[i] > 0){
                operatorCount[i]--;
                operator[count] = i;
                dfs(count + 1);
                operatorCount[i]++;
            }
        }

    }
    public static int calculate(){
        int result = arr[0];
        for(int i=0; i<n-1; i++){
            switch (operator[i]){
                case 0:
                    result += arr[i+1];
                    break;
                case 1:
                    result -= arr[i+1];
                    break;
                case 2:
                    result *= arr[i+1];
                    break;
                case 3:
                    result /= arr[i+1];
                    break;
            }
        }
        return result;
    }
}