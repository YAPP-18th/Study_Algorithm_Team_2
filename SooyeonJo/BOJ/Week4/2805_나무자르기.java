import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static int n, m;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch());
        br.close();
    }

    public static int binarySearch(){
        int start = 0, end = (int) 1e9;
        int result = 0;
        while(start <= end){
            long total = 0;
            int mid = (start + end) / 2;
            for(int i=0; i<n; i++){
                if(arr[i] > mid){
                    total += arr[i] - mid;
                }
            }
            if(total < m){
                end = mid - 1;
            }else{
                result = mid;
                start = mid + 1;
            }
        }
        return result;
    }
}
