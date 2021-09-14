import java.util.*;

class Solution {
    ArrayList<ArrayList<ArrayList<String>>> place_array = new ArrayList<>();
    int[][] visited;
    int[] x_arr = {1, 0, -1, 0};
    int[] y_arr = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(String[] place : places) {
            ArrayList<ArrayList<String>> place_arr = new ArrayList<>();
            for(String status : place) {
                place_arr.add(
                    new ArrayList<String>(
                        Arrays.asList(status.split(""))
                    )
                );
            }
            place_array.add(place_arr);
        }
        
        int cnt = -1;
        
        for(ArrayList<ArrayList<String>> place : place_array) {
            cnt ++;
            if(isValidDistance(place)) {
                answer[cnt] = 1;
                continue;
            }
            answer[cnt] = 0;
        }
        
        
        return answer;
    }
    
    private boolean isValidDistance(ArrayList<ArrayList<String>> place) {
        visited = new int[5][5];
        for(int i = 0; i < 5; i ++) {
            for(int j = 0; j < 5; j ++) {
                if(place.get(i).get(j).equals("P")) {
                    visited[i][j] = 1;
                    if (!dfs(place, 0, i, j)) {
                        return false;
                    }
                    visited[i][j] = 0;
                }
            }
        }
        
        return true;
    }
    
    private boolean dfs(ArrayList<ArrayList<String>> place, int depth, int x, int y) {
        boolean result = true;
        
        if(depth == 2) {
            return true;
        }
        
        for(int i = 0; i < 4; i ++) {
            int new_x = x + x_arr[i];
            int new_y = y + y_arr[i];
            if(!isValid(new_x, new_y)) continue;
            
            String next_value = place.get(new_x).get(new_y);
            
            if(next_value.equals("X") || visited[new_x][new_y] == 1) continue;
            if(next_value.equals("P")) {
                return false;
            }
            
            visited[new_x][new_y] = 1;
            result = dfs(place, depth + 1, new_x, new_y);
            
            if(!result) {
                return false;
            }
            visited[new_x][new_y] = 0;
        }
        
        return result;
    }
    
    private boolean isValid(int x, int y) {
        if(x < 0 || 4 < x) return false;
        if(y < 0 || 4 < y) return false;
        if(visited[x][y] == 1) return false;
        
        return true;
    }
}
