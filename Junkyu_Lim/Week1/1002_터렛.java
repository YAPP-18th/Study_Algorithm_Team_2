import java.io.*;
import java.util.*;
import java.math.*;

class tarret {
    public static void main(String[] args) throws IOException{
        BufferedReader brd = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(brd.readLine());

        for(int i =0; i < n; i ++){
            StringTokenizer st = new StringTokenizer(brd.readLine(), " ");
            int ax = Integer.parseInt( st.nextToken());
            int ay = Integer.parseInt( st.nextToken());
            int ar = Integer.parseInt( st.nextToken());
            int bx = Integer.parseInt( st.nextToken());
            int by = Integer.parseInt( st.nextToken());
            int br = Integer.parseInt( st.nextToken());

            double dist = getDistance(ax,ay,bx,by);
            // 1. a의 좌표와 b의 좌표가 동일할 때
            if(dist == 0){
            // 1-1. 반지름이 동일할 때 / return -1
                if(ar == br) System.out.println(-1);
            // 1-2. 아님 return0
                else System.out.println(0);
            }
            else{
                // 2. 반지름의 합이 좌표 간의 거리보다 길거나 같을 때
                if(dist <= ar+br){
                    if(ar > br+dist || br > ar + dist) System.out.println(0);
                    else if(ar == br+dist || br == ar + dist) System.out.println(1);
                    else if(dist == ar+br) System.out.println(1);
                    else System.out.println(2);
                }
                // 2-1. 한 원의 반지름이 좌표간 거리 + 반지름 보다 길때 0
                // 2-2. 한 원의 반지름이 좌표간 거리 + 반지름 같을 때 1
                // 2-3. 아무것도 아니다. 2

                // 3. 반지름의 합이 좌표간의 거리보다 짧을 때
                // 0
                else if(dist > ar+br) System.out.println(0);
            }
        }
    }

    public static double getDistance(int ax, int ay, int bx, int by){
        return Math.sqrt((Math.pow((ax-bx),2)) + ((Math.pow((ay-by),2))));
    }
}
