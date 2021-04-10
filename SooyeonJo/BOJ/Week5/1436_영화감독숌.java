import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main{
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int num = 666;
        
        while(n > 1){
            num++;
            if(String.valueOf(num).contains("666")){
                n--;
            }
        }
        System.out.println(num);
        br.close();
    }
}
