import java.util.*;

class Solution {
    public static HashMap<String, List<Integer>> infoMap = new HashMap<>();
    public static boolean[] visited;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String s : info) {
            String[] sliceInfo = s.split(" ");
            visited = new boolean[sliceInfo.length];
            combination(sliceInfo, "", 0, 0);
        }

        for (Map.Entry<String, List<Integer>> entry : infoMap.entrySet()) {
            Collections.sort(entry.getValue());
        }

        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] sliceQuery = query[i].split(" ");
            int score = Integer.parseInt(sliceQuery[1]);

            answer[i] = infoMap.containsKey(sliceQuery[0]) ? binarySearch(infoMap.get(sliceQuery[0]), score) : 0;
        }

        return answer;
    }

    public void combination(String[] arr, String s, int start, int r) {
        if (r == 4) {
            List<Integer> list = new ArrayList<>();
            if (infoMap.containsKey(s)) {
                if (infoMap.get(s) != null) {
                    list = infoMap.get(s);
                }
            }
            list.add(Integer.parseInt(arr[arr.length - 1]));
            infoMap.put(s, list);
            return;
        }

        for (int i = start; i < arr.length - 1; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            combination(arr, s + arr[i], i, r + 1);
            combination(arr, s + "-", i, r + 1);
            visited[i] = false;
        }
    }

    public int binarySearch(List<Integer> list, int score) {
        int start = 0, end = list.size();

        while(end > start){
            int mid = (start + end) / 2;
            if(list.get(mid) >= score){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return list.size() - start;
    }
}
