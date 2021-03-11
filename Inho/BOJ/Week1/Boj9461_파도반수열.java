package week1;
import java.io.*;
import java.util.*;

public class Boj9461_파도반수열 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);		
		int testCase = sc.nextInt();
		long [] dp = new long [101];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		for(int i=3; i<101; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}		
		for(int i=0; i<testCase; i++) {			
			int n = sc.nextInt();	
			
			System.out.println(dp[n]);			
		}
		sc.close();
		
	}

}
