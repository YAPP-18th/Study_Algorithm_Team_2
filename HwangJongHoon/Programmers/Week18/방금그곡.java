package Programmers.YAPP.Week18;

import java.util.*;

public class 방금그곡 {
    static class Solution {
        class Music implements Comparable {
            public String title;
            public int time;
            public int order;

            Music(String title, int time, int order) {
                this.title = title;
                this.time = time;
                this.order = order;
            }

            @Override
            public int compareTo(Object obj) {
                Music music = (Music) obj;
                if (this.time != music.time) return this.time - music.time;
                else return music.order - this.order;
            }
        }

        public String solution(String m, String[] musicinfos) {
            PriorityQueue<Music> pq = new PriorityQueue<>(Collections.reverseOrder());
            String seperatedM = seperate(m);
            int order = 1;

            for (String s : musicinfos) {
                String[] info = s.split(",");
                String[] start = info[0].split(":");
                String[] end = info[1].split(":");

                int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
                int minute;
                int sMinute = Integer.parseInt(start[1]);
                int eMinute = Integer.parseInt(end[1]);
                
                if (sMinute > eMinute) {
                    minute = (60 - sMinute) + eMinute;
                    hour--;
                } else {
                    minute = eMinute - sMinute;
                }

                String seperatedInfo = seperate(info[3]);
                int len = seperatedInfo.split(",").length; 
                int time = hour * 60 + minute; 

                String result;
                if (time > len) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < time / len; ++i) {
                        sb.append(seperatedInfo);
                    }
                    sb.append(cutCode(seperatedInfo, time % len));
                    result = sb.toString();
                } else {
                    result = seperate(info[3].substring(0, time + (info[3].length() - len)));
                }
                if (result.contains(seperatedM)) {
                    pq.add(new Music(info[2], time, order++));
                }
            }
            if (pq.isEmpty()) return "(None)";
            Music answer = pq.poll();
            return answer.title;
        }

        public String cutCode(String code, int len) {
            String[] seperated = code.split(",");
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < len; ++i){
                sb.append(seperated[i] + ",");
            }
            return sb.toString();
        }

        public String seperate(String code) {
            code = code.replace("", ",");
            code = code.replace(",#", "#");
            return code.substring(1);
        }
    }
}
