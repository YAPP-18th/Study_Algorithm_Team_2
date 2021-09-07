import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        
        
        Arrays.sort(timetable);
        
        Queue<Integer> crew = new LinkedList<Integer>();
        
        for(String time : timetable) {
            crew.add(timeToInt(time));
        }
        
        Integer busTime = 9 * 60;
        Integer answer = 0;
        
        while(true) {
            int busLimit = m;
            
            int lastTime = 0;
            
            while (!crew.isEmpty()) {
                if(crew.peek() <= busTime && busLimit > 0) {
                    busLimit --;
                    lastTime = crew.poll();
                    continue;
                }
                
                break;
            }
            
            n --;
            
            if (n > 0){
                if (crew.isEmpty()) {
                    answer = busTime +((n+1)*t);
                    break;
                }

                busTime += t;
            }
            else {
                if(busLimit > 0) answer = busTime;
                else answer = lastTime - 1;
                break;
            }
        }
        
        return timeToString(answer);
    }
    
    private Integer timeToInt(String time) {
        int H = Integer.parseInt(time.substring(0, 2));
        int M = Integer.parseInt(time.substring(3, 5));
        
        return (H * 60) + M;
    }
    
    private String timeToString(Integer time) {
        int H = time / 60;
		int M = time % 60;
        
		String timeString = "";
		timeString += H / 10 == 0 ? "0" + H : H;
		timeString += ":";
		timeString += M / 10 == 0 ? "0" + M : M;
        
        return timeString;
    }
}
