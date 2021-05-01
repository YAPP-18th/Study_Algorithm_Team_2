import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public int solution(String numbers) {
        ArrayList<Integer> ara = ara(10000000);
        int answer = 0;
        
        HashSet<Integer> hs = new HashSet<>();
        
        getSS("", numbers, hs);
        
        for(int i: hs){
            if(ara.contains(i)) answer ++;
        }
        
        return answer;
    }
    
    public ArrayList<Integer> ara(int limit) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int[] ara = new int[limit];
        for(int i = 2; i < ara.length; i++ ) {
            if(ara[i] == 0) {
                int idx = 0;
                int count = 1;
                while(true) {
                    idx ++;
                    count = idx * i;
                    
                    if(count >= limit) break;
                    
                    ara[count] = -1;
                }
                
                res.add(i);
            } else continue;
        }
        
        return res;
    }
    
    public int strToInt(String target) {
        return Integer.parseInt(target);
    }
    
    public void getSS(String str, String remainString, HashSet<Integer> hs) {
        if(str.length() != 0) hs.add(strToInt(str));
        
        for(int i = 0; i < remainString.length(); i ++) {
            getSS(str + remainString.charAt(i), remainString.substring(0,i) + remainString.substring(i+1), hs);
        }
    }
}