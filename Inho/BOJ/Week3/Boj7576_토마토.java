package Study_Algorithm_Team_2.Inho.BOJ.Week3;
import java.util.*;
import java.io.*;
class Boj7576 {
    static int [][] arr;
    static boolean [][] check;
    static int n;
    static int m;
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};
    static Queue <int []> list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        list = new LinkedList<int []> ();
        arr = new int [n][m];
        check = new boolean [n][m];

        // input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        bw.write(calcDay()+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs(){

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j] == 1){
                    list.add(new int [] {i, j});
                    check[i][j] = true;
                }
            }
        }

        while(!list.isEmpty()){
            int tmp [] = list.poll();
            int x = tmp[0];
            int y = tmp[1];
            int value = arr[x][y];

            for(int i=0; i<4; i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m){
                    continue;
                }
                if(!check[nextX][nextY] && arr[nextX][nextY] == 0){
                    check[nextX][nextY] = true;
                    list.offer(new int [] {nextX, nextY});
                    arr[nextX][nextY] = value + 1;
                }
                
            }
        }
    }
    public static int calcDay(){
        int max = -1;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int value = arr[i][j];
                if(value == 0){
                    return -1;
                }
                max = Math.max(value, max);
                int l=123;
            }
        }
        return max - 1;
    }
}
