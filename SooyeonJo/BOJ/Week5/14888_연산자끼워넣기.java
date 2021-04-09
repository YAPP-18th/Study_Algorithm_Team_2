import java.util.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
    public static int n;
    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] arr;
    public static int[] operator = new int[4];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
        br.close();
    }
    
    public static void dfs(int num, int index){
        if(index == n){
            max = Math.max(num, max);
            min = Math.min(num, min);
            return;
        }
        
        for(int i=0; i<4; i++){
            if(operator[i] <= 0) continue;
            operator[i]--;
            switch(i){
                case 0: dfs(num + arr[index], index+1); break;
                case 1: dfs(num - arr[index], index+1); break;
                case 2: dfs(num * arr[index], index+1); break;
                case 3: dfs(num / arr[index], index+1); break;
            }
            operator[i]++;
        }
    }
}
