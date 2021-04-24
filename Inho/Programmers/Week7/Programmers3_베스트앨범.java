import java.util.*;
class sdf{
    public static void main(String[] args){
        // String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        // int[] plays = {500, 600, 150, 800, 2500};
        String[] genres = {"classic", "pop", "classic", "classic","jazz","pop", "Rock", "jazz"};
        int[] plays = {500, 600, 150, 800, 1100, 2500, 100, 1000};
        int [] answer = solution(genres, plays);
        for(int i: answer){
            System.out.println(i);
        }
    }
     public static int [] solution(String[] genres, int[] plays) {
        LinkedHashMap<String, ArrayList<Integer>> hm = new LinkedHashMap<>();
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<genres.length; i++){
            ArrayList<Integer> tmp = hm.get(genres[i]) ;

            // 값 없으면 리스트 생성
            if(tmp == null){
                tmp = new ArrayList<>();
                tmp.add(0);
            }

            // 리스트 0번째 값에 선정된 곡 플레이 수 더하기
            tmp.set(0, tmp.get(0) + plays[i]);

            // 인덱스 더하기
            tmp.add(i);
            
            // 해쉬맵 갱신
            hm.put(genres[i], tmp);
        }
        
        Map<String, ArrayList<Integer>> sortedHm = sortMapByValue(hm);

        for (Map.Entry<String, ArrayList<Integer>> entry : sortedHm.entrySet()) {
            ArrayList<Integer> tmp = entry.getValue();
            tmp.remove(0);
            Collections.sort(tmp, (o1, o2) -> ((Integer)plays[o2]).compareTo((Integer)plays[o1]));
            answer.add(tmp.get(0));
            if(tmp.size() > 1){
                answer.add(tmp.get(1));
            }
        }           
        return answer.stream().mapToInt(x -> x).toArray();
    }

    // 순서가 보장되는 것이 LinkedHashMap
    public static LinkedHashMap<String, ArrayList<Integer>> sortMapByValue(Map<String, ArrayList<Integer>> map) {
        List<Map.Entry<String, ArrayList<Integer>>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o2.getValue().get(0).compareTo(o1.getValue().get(0)));
    
        LinkedHashMap<String, ArrayList<Integer>> result = new LinkedHashMap<>();
        for (Map.Entry<String, ArrayList<Integer>> entry : entries) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}