import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Cache cache = new Cache(cacheSize);
        
        for(String city : cities) {
            String pCity = city.toLowerCase();
            if(cache.isHit(pCity)) {
                answer += 1;
            } else {
                answer += 5;
                cache.add(pCity);
            }
            // for(City c : cache.cache) {
            //     System.out.print(c.cityName + c.lastHit + " ");
            // }
            // System.out.println();
        }
        
        return answer;
    }
}
class Cache {
    LinkedList<String> cache;
    int maxSize;
    
    public Cache(int size) {
        cache = new LinkedList<>();
        this.maxSize = size;
    }
    
    public void add(String cityName) {
        if(maxSize == 0) return;
        
        if(cache.size() < maxSize) {
            cache.add(cityName);
            return;
        }
        
        cache.removeFirst();
        cache.add(cityName);
        return;
    }
    
    public boolean isHit(String cityName) {
        boolean result = false;
        for(int i = 0; i < cache.size(); i ++) {
            if(cache.get(i).equals(cityName)) {
                cache.add(cache.remove(i));
                return true;
            }
        }
        
        return result;
    }
}

// class City implements Comparable<City> {
//     String cityName;
//     int lastHit = 0;
    
//     public City(String name) {
//         this.cityName = name;
//     }
    
//     @Override
//     public int compareTo(City c) {
//         return c.lastHit - this.lastHit;
//     }
// }
