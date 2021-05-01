package Programmers.YAPP.Week8;

import java.util.*;

public class 소수찾기 {
    static class Solution {
        static final int LEN = 10000000;
        static boolean[] isPrime;
        static int prime = 0;
        public int solution(String numbers) {
            isPrime = new boolean[LEN + 1];
            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;
            for(int i = 2; i <= Math.sqrt(LEN); ++i){
                if(!isPrime[i]) continue;
                for(int j = i + i; j <= LEN; j+=i){
                    isPrime[j] = false;
                }
            }
            List<String> list = new ArrayList<>(Arrays.asList(numbers.split("")));
            Set<Integer> set = new HashSet<>();

            for(int i =0; i < list.size(); ++i){
                Collections.sort(list);
                String current = list.remove(i);
                permutaion(set, list, current);
                list.add(current);
            }

            for(int val : set){
                if(isPrime[val]) prime++;
            }
            return prime;
        }

        public static void permutaion(Set<Integer> set, List<String> list, String current){
            set.add(Integer.parseInt(current));
            if(list.size() == 0) return;;

            for(int i = 0; i < list.size(); ++i){
                String next = list.remove(0);
                permutaion(set, list, current + next);
                list.add(next);
            }
        }
    }
}
