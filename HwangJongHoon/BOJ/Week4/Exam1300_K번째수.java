package Baekjoon.BinarySearch;

import java.io.IOException;
import java.util.Scanner;

public class Exam1300_K번째수 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        long result = 0;

        // A[i][j] = i * j인 2차원 배열을 1차원 배열 B로 만들고 오름차순으로 정렬했을때,
        // B[k]를 구하라. 단 A와 B의 인덱스는 1부터 시작한다.

        long start = 1;
        long end = K;
        long mid = 0;
        while(start <= end){
            long cnt = 0;
            mid = (start + end) / 2;
            for(int i = 1; i <= N; ++i){
                cnt += Math.min(mid / i, N);
            }
            if(cnt >= K){
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
