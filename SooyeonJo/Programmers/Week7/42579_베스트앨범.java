import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> totalPlays = new HashMap<>();
        HashMap<Integer, Integer> musicInfo = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            musicInfo.put(i, plays[i]);
        }

        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Map.Entry<String, Integer>> sortedTotalPlays = new ArrayList<>(totalPlays.entrySet());
        sortedTotalPlays.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        ArrayList<Map.Entry<Integer, Integer>> sortedMusicInfo = new ArrayList<>(musicInfo.entrySet());
        sortedMusicInfo.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        for (int i = 0; i < sortedTotalPlays.size(); i++) {
            int cnt = 0;
            for(int j=0; j<sortedMusicInfo.size(); j++){
                if(sortedTotalPlays.get(i).getKey().equals(genres[sortedMusicInfo.get(j).getKey()])){
                    result.add(sortedMusicInfo.get(j).getKey());
                    if(sortedTotalPlays.get(i).getValue().equals(sortedMusicInfo.get(j).getValue())){
                        j=sortedMusicInfo.size()-1;
                    }else{
                        cnt++;
                    }
                }
                if(cnt == 2){
                    j = sortedMusicInfo.size()-1;
                }
            }
        }
        return result.stream().mapToInt(integer -> integer).toArray();
    }
}
