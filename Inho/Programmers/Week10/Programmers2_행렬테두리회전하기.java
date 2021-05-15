
// 테스트케이스 3번부터 통과 못하는 코드

// import java.util.LinkedList;
// import java.util.Queue;
// class Solution {
//     public int[] solution(int rows, int columns, int[][] queries) {
//         int [] answer = new int [queries.length];
//         int [][] map = new int [rows][columns];
//         int count = 1;
//         for(int i=0; i<rows; i++){
//             for(int j=0; j<columns; j++){
//                 // map[i][j] = count;
//                 // count++;
//                 map[i][j] = (i * columns)+ j+1;
//             }
//         }
//         for(int k=0; k<queries.length; k++){
//             int min = Integer.MAX_VALUE;
//             Queue <Integer> queue = new LinkedList<Integer>();
        
//             int [] tmp = queries[k];
//             // 어떻게 회전?
//             int r1 = tmp[0] - 1;
//             int c1 = tmp[1] - 1;
//             int r2 = tmp[2] - 1;
//             int c2 = tmp[3] - 1;
//             queue.add(Integer.MAX_VALUE);
//             for(int i=c1; i<=c2; i++){
//                 min = Math.min(map[r1][i], min);
//                 queue.add(map[r1][i]);
//                 map[r1][i] = queue.poll();
//             }

//             for(int j=r1+1; j<=r2; j++){
//                 min = Math.min(map[j][c2], min);
//                 queue.add(map[j][c2]);
//                 map[j][c2] = queue.poll();
                
//             }

//             for(int i=c2-1; i>=c1; i--){
//                 min = Math.min(map[r2][i], min);
//                 queue.add(map[r2][i]);
//                 map[r2][i] = queue.poll();
                
//             }

//             for(int j=r2-1; j>=r1; j--){
//                 min = Math.min(map[j][c2], min);
//                 queue.add(map[j][c1]);
//                 map[j][c1] = queue.poll();
                
//             }
//             answer[k] = min;
                 
//         // for(int i=0; i<rows; i++){
//         //     for(int j=0; j<columns; j++){
//         //         System.out.print(map[i][j]+ " ");
//         //     }
//         //     System.out.println();
//         // }
//         }
        
//         return answer;
//     }
// }

import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int [] answer = new int [queries.length];
        int [][] map = new int [rows+1][columns+1];
        for(int i=1; i<=rows; i++){
            for(int j=1; j<=columns; j++){
                map[i][j] = ((i-1) * columns)+ j;
            }
        }
        for(int k=0; k<queries.length; k++){
        
            int [] tmp = queries[k];
            int min = map[tmp[0]][tmp[1]];
            
            // 어떻게 회전?
            int r1 = tmp[0] ;
            int c1 = tmp[1] ;
            int r2 = tmp[2] ;
            int c2 = tmp[3] ;
            int start = map[r1][c1];
            
            for(int i=r1; i<r2; i++){
                min = Math.min(map[i][c1], min);
                map[i][c1] = map[i+1][c1];
            }

            for(int i=c1; i<c2; i++){
                min = Math.min(map[r2][i], min);
                map[r2][i] = map[r2][i+1];
            }

            for(int i=r2; i>r1; i--){
                min = Math.min(map[i][c2], min);
                map[i][c2] = map[i-1][c2];
            }

            for(int i=c2; i>c1; i--){
                min = Math.min(map[r1][i], min);
                map[r1][i] = map[r1][i-1];
            }
            
            
            map[r1][c1+1] = start;
            answer[k] = min;
                 
        // for(int i=0; i<=rows; i++){
        //     for(int j=0; j<=columns; j++){
        //         System.out.print(map[i][j]+ " ");
        //     }
        //     System.out.println();
        // }
        }
        
        return answer;
    }
}