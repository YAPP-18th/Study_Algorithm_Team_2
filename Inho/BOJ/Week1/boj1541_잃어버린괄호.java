package Algorithm.yapp;
import java.io.*;
class lain{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = br.readLine().split("\\-");
        int length = line.length;
        
        int result = calc(line[0]);
        for(int i=1; i<length; i++){
            result -= calc(line[i]);
        }
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int calc(String a){
        int sum = 0;
        String[] line = a.split("\\+");
        for(String i : line){
            sum += Integer.parseInt(i);
        }
        return sum;
    }
}
