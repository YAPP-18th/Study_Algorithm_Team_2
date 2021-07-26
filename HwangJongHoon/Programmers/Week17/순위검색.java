package Programmers.YAPP.Week17;

import java.util.*;

public class 순위검색 {
    static class Solution {
        public int[] solution(String[] info, String[] query) {
            final int LEN = 4;
            int[] answer = new int[query.length];
            StringBuilder sb;
            Map<String, ArrayList<Integer>> infoMap = new HashMap<>(); // 쿼리 조합에 따른 점수를 저장하기 위한 hashmap
            for(String str : info){ // 유저 정보 배열 info로 루프
                String[] temp = str.split(" ");
                for(int i = 0; i < (1 << LEN); ++i){ // 범위는 0 ~ 15 (0 ~ 1111)
                    sb = new StringBuilder();
                    for(int j = 0; j < LEN; ++j){
                        // 비트 마스킹을 사용한 4C1 ~ 4C4 조합 구하기
                        if((i & (1 << j)) > 0) sb.append(temp[j]);
                    }
                    //조합한 sb를 key로 ArrayList가 존재하지 않는다면 생성해주고 존재한다면 점수를 추가해준다.
                    infoMap.computeIfAbsent(sb.toString(), s -> new ArrayList<>()).add(Integer.parseInt(temp[4]));
                }
            }
            for(String key : infoMap.keySet()){
                //이진 탐색을 위한 ArrayList 정렬
                infoMap.get(key).sort(null);
            }

            ArrayList<Integer> empty = new ArrayList<>();
            for(int i = 0; i < query.length; ++i){
                String score = query[i].split(" ")[7];
                //query string을 hashmap key에 맞게 변환
                String refined = query[i]
                        .replace(score, "")
                        .replace("-", "")
                        .replace("and", "")
                        .replace(" ", "");
                //query에 따라 map에 존재하지 않는 key도 있을 수 있으므로 그럴 땐 빈 리스트를 반환
                ArrayList<Integer> list = infoMap.getOrDefault(refined, empty);
                //info 배열 크기가 최대 50,000 query 배열 크기가 최대 100,000이라
                //이분 탐색을 이용해 score 미만의 점수 갯수를 구하여 list.size()에서 빼주면 score 이상의 점수 갯수가 된다.
                answer[i] = list.size() - binarySearch(list, Integer.parseInt(score));
            }
            return answer;
        }

        public int binarySearch(ArrayList<Integer> list, int score){
            int start = 0;
            int end = list.size();
            while(start < end){
                int mid = (start + end) / 2;
                if(list.get(mid) < score) start = mid + 1;
                else end = mid;
            }
            return start;
        }
    }
}
