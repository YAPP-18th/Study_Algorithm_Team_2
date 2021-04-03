import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static long n, k;

    public static long binarySearch(long start, long end){
        long result = 0;
        while(start <= end){
            long count = 0;
            long mid = (start + end) / 2;

            for(int i=1; i<=n; i++){
                count += Math.min(mid / i, n);
            }

            if(count < k){
                start = mid + 1;
            }else{
                result = mid;
                end = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        k = Long.parseLong(br.readLine());

        long start = 1;
        long end = k;
        System.out.println(binarySearch(start, end));

        br.close();
    }
}
