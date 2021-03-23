import java.util.*;
import java.io.*;

public class coin {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt( st.nextToken());
        int K = Integer.parseInt( st.nextToken());

        ArrayList<Integer> coinBox = new ArrayList<Integer>();
        int coinCoint = 0;
        
        for (int i = 0; i < N; i++) {
            coinBox.add(0,Integer.parseInt(br.readLine()));
        }
        for(int coin : coinBox){
            coinCoint += K / coin;
            K %= coin;
        }
        System.out.println(coinCoint);
    }
}
