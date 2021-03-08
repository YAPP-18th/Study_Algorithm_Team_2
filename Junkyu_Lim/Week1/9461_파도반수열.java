import java.io.*;
import java.util.*;

class padoban{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Long> ar = new ArrayList<Long>();
        ar.add(0, (long)0);ar.add(1, (long)1); ar.add(2, (long)1); ar.add(3, (long)1); ar.add(4, (long)2); ar.add(5, (long)2);

        for (int i = 6; i <= 100; i ++){
            ar.add(i, ar.get(i-1) + ar.get(i-5));
        }
        for(int i = 0; i < n; i ++){
            int inp = Integer.parseInt(br.readLine());
            System.out.println(ar.get(inp));
        }
    }
}