import java.util.*;
class Solution {
    public int solution(String[] lines) {
        int [] endT = new int [lines.length];
        int max = 0;
        
        LinkedList<Cell> list = new LinkedList<>();
        
        for(int i=0; i<lines.length; i++){
            int [] tmp = strToMs(lines[i]);
            endT[i] = tmp[1];
            Cell c = new Cell(i, tmp[0]);
            list.add(c);
        }
        
        Collections.sort(list);
        
        for(int i=0; i<endT.length; i++){
            list.removeFirst();
            
            int endTime = endT[i];
            
            int cnt = 1;
            for(Cell c: list){
                if(endTime + 998 >= c.startMs){
                    cnt++;                    
                }
            }
            
            max = Math.max(max, cnt);
        }
        
        return max;
    }
    
    public int[] strToMs(String line){
        String str = line.substring(11);
        
        String [] arr = str.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        
        String [] arr2 = arr[2].split(" ");
        
        String [] arr3 = arr2[0].split("\\.");
        int sec = Integer.parseInt(arr3[0]);
        int ms = Integer.parseInt(arr3[1]);
        
        int last = arr2[1].indexOf("s");
        int addT = (int)(Double.parseDouble(arr2[1].substring(0, last)) * 1000);
        
        int end = hour * 3600000 + min * 60000 + sec * 1000 + ms;
        int start = end - addT;
        
        return new int [] {start, end};
    }
}

class Cell implements Comparable<Cell>{
    int idx;
    int startMs;
    Cell(int idx, int startMs){
        this.idx = idx;
        this.startMs = startMs;
    }
    
    @Override
    public int compareTo(Cell c){
       return this.startMs - c.startMs;
    }
}