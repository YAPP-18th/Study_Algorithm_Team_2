package Baekjoon.Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class Exam11047_동전0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N];
        int cnt = 0;

        for(int i = 0; i < N; ++i){
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i >= 0; --i){
            if(K <= 0) break;
            while(K >= coin[i]){
                K -= coin[i];
                cnt++;
            }
        }

        System.out.println(cnt);

        br.close();
    }
}
