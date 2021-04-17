package Programmers.YAPP.Week6;

import java.util.*;

public class 기능개발 {
    private static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            List<Integer> prolist = new LinkedList<>();
            List<Integer> spelist = new LinkedList<>();
            List<Integer> resultList = new LinkedList<>();

            for (int i = 0; i < progresses.length; ++i) {
                prolist.add(progresses[i]);
                spelist.add(speeds[i]);
            }
            while (true) {
                if(prolist.isEmpty() && spelist.isEmpty()) break;
                int cnt = 0; // 100 퍼센트 진행된 기능의 수
                while (!prolist.isEmpty() && prolist.get(0) >= 100) {
                    prolist.remove(0);
                    spelist.remove(0);
                    cnt++;
                }
                if (cnt > 0) resultList.add(cnt);

                int size = prolist.size();

                for (int i = 0; i < size; ++i) {
                    prolist.add(prolist.remove(0) + spelist.get(i));
                }
            }

            int size = resultList.size();
            int[] answer = new int[size];
            for (int i = 0; i < size; ++i) {
                answer[i] = resultList.remove(0);
            }
            return answer;
        }
    }
}
