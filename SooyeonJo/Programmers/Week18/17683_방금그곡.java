class Solution {
    public String solution(String m, String[] musicinfos) {
       String answer = "(None)";

        String userMelody = replaceMelody(m);

        int longTime = 0;

        for(int i=0; i<musicinfos.length; i++){
            String[] musicInfo = musicinfos[i].split(",");

            int time = getPlayTime(musicInfo[0], musicInfo[1]);

            String infoMelody = replaceMelody(musicInfo[3]);
            StringBuilder sb = new StringBuilder();

            if(time > infoMelody.length()){
                for(int j=0; j<time/infoMelody.length(); j++){
                    sb.append(infoMelody);
                }

                sb.append(infoMelody, 0, time % infoMelody.length());
            }else{
                sb.append(infoMelody, 0, time);
            }

            if(sb.toString().contains(userMelody)){
                if(longTime < sb.toString().length()){
                    longTime = sb.toString().length();
                    answer = musicInfo[2];
                }
            }

        }

        return answer;
    }

    public String replaceMelody(String m){
        for(int i=0; i<m.length(); i++){
            m = m.replaceAll("A#", "a");
            m = m.replaceAll("C#", "c");
            m = m.replaceAll("D#", "d");
            m = m.replaceAll("E#", "e");
            m = m.replaceAll("F#", "f");
            m = m.replaceAll("G#", "g");
        }

        return m;
    }

    public int getPlayTime(String start, String end){
        int hour = Integer.parseInt(end.substring(0,2)) - Integer.parseInt(start.substring(0, 2));
        int minute = Integer.parseInt(end.substring(3)) - Integer.parseInt(start.substring(3));

        return (hour * 60) + minute;
    }
}
