package Baekjoon.Bruteforce;

import java.util.Scanner;

public class Exam1436_영화감독숌 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 666;
        int cnt = 0;
        while(cnt < N){
            if(String.valueOf(num).contains("666")) cnt++;
            num++;
        }
        System.out.println(String.valueOf(num - 1));
    }
}