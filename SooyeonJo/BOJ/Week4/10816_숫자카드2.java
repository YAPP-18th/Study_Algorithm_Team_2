import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static int n, m;
    public static int[] myCard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        myCard = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            myCard[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(myCard);

        m = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int card = Integer.parseInt(st.nextToken());
            sb.append(upper(card) - lower(card)).append(" ");
        }

        System.out.println(sb);
        br.close();
    }

    private static int lower(int target) {
        int start = 0, end = n;
        while(start < end){
            int mid = (start + end) / 2;
            if(myCard[mid] >= target){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }

    private static int upper(int target) {
        int start = 0, end = n;
        while(start < end){
            int mid = (start + end) / 2;
            if(myCard[mid] <= target){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
}
