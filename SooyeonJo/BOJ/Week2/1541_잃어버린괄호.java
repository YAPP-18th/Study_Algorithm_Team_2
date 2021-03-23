import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split("-");

        int result = sum(str[0].split("\\+"));

        for(int i=1; i<str.length; i++){
            result -= sum(str[i].split("\\+"));
        }
        
        System.out.println(result);
    }
    
    public static int sum(String[] input){
        int result = 0;
        for(String num : input){
            result += Integer.parseInt(num);
        }
        return result;
    }
}
