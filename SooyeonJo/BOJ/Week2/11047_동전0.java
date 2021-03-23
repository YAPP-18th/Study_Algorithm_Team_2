import java.util.Scanner;

public class Main{
    public static int[] coins = new int[10];
    public static int n, k;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i=0; i<n; i++){
            coins[i] = sc.nextInt();
        }
        
        int min = 0;
        int i = n-1;
        while(k > 0 || i >= 0){
            if(coins[i] <= k){
                min += k / coins[i];
                k %= coins[i];
            }
            i--;
        }
        System.out.println(min);
    }
}
