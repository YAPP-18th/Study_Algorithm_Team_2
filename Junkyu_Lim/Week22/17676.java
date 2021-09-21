import java.util.*;

class Solution {
    public int solution(String[] lines) {
        ArrayList<Log> logs = new ArrayList<>();
        int answer = 0;
        
        for(String line : lines) {
            logs.add(getLog(line));
        }
        
        for(Log log : logs) {
            int sCount = 0;
            int eCount = 0;
            
            for (Log iLog : logs) {
                if (log.startTime <= iLog.endTime && iLog.startTime <= log.startTime + 999)
                    sCount ++;
                
                if (log.endTime <= iLog.endTime && iLog.startTime <= log.endTime + 999)
                    eCount ++;
            }
            
            answer = Math.max(Math.max(sCount, eCount), answer);
        }
        
        return answer;
    }
    
    private Log getLog(String line) {
        String[] splitLine = line.split(" ");
        
        String[] responseTimes = splitLine[1].split(":");
        int handleTime = (int)(Double.parseDouble(splitLine[2].replace("s", "")) * 1000);

        int endTime = 0;
        int startTime = 0;
        
        endTime += 3600 * 1000 * Integer.parseInt(responseTimes[0]);
        endTime += 60 * 1000  * Integer.parseInt(responseTimes[1]);
        endTime += (int)(Double.parseDouble(responseTimes[2]) * 1000);

        startTime = endTime - handleTime + 1;

        return new Log(startTime, endTime);
    }
}

class Log {
    int startTime;
    int endTime;
    
    public Log(int s, int e) {
        this.startTime = s;
        this.endTime = e;
    }
    
    @Override
    public String toString(){
        return "s : " + startTime + " / e : " + endTime;
    }
}
