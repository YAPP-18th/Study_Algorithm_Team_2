package week1;
import java.io.*;
import java.util.*;
public class Boj9020_골드바흐의추측 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[10001];
		for(int i=2; i<=10000; i++) {
			arr[i] = i;
		}
		for(int i=2; i<=Math.sqrt(10000); i++) {
			if(arr[i] == 0) {
				continue;
			}
			for(int j = i+i; j<=10000; j+=i) {
				arr[j] = 0;
			}
		}
		int testCase = sc.nextInt();
		for(int i=0; i< testCase; i++) {
			int n = sc.nextInt();
			for(int j=n/2; j<n; j++) {
				if(arr[j] > 0 && arr[n-j] > 0) {
					System.out.println(arr[n-j] + " " + arr[j]);
					break;
				}
			}
		}
		sc.close();
	}
}

