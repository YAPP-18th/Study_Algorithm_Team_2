import java.util.*;
import java.io.*;

public class bucket {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        ArrayList<String> minusSplit = new ArrayList<String>();
        ArrayList<Integer> processedSplit = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(input, "-");

        while(st.hasMoreTokens()){
            minusSplit.add(st.nextToken());
        }

        for(String stub : minusSplit){
            StringTokenizer st2 = new StringTokenizer(stub, "+");
            int res = 0;

            while(st2.hasMoreTokens()){
                res += Integer.parseInt(st2.nextToken());
                
            }
            processedSplit.add(res);
        }

        int Answer = processedSplit.remove(0);

        for(int i : processedSplit) Answer -= i;

        System.out.println(Answer);
    }
}
