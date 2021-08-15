import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String mSharp = rmSharps(m);
        String answer = "(None)";
        int size = 0;
        
        for(String info : musicinfos) {
            String[] infos = info.split(",");
            
            int startTime = getMin(infos[0]);
            int endTime = getMin(infos[1]);
            int playTime = endTime - startTime;
            
            String musicSharp = rmSharps(infos[3]);
            String fullMusic = getFullMusic(playTime, musicSharp);
            
            if (fullMusic.contains(mSharp)) {
                if (playTime > size) {
                    size = playTime;
                    answer = infos[2];
                }
            }
        }
        
        
        return answer;
    }
    
    private String rmSharps(String music) {
        return music.replaceAll("A#", "a")
            .replaceAll("C#", "c")
            .replaceAll("D#", "d")
            .replaceAll("F#", "f")
            .replaceAll("G#", "g");
    }
    
    private int getMin(String time) {
        String[] times = time.split(":");
        int h = Integer.parseInt(times[0]);
        int m = Integer.parseInt(times[1]);
        
        return h * 60 + m;
    }
    
    private String getFullMusic(int m, String music) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m / music.length(); i ++) {
            sb.append(music);
        }
        sb.append(music.substring(0, m % music.length()));
        
        return sb.toString();
    }
}
