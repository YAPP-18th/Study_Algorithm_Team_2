import java.util.*;
import java.io.*;

class goldbach{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        // 에라토스테네스의 체
        int[] ara = new int[10001];

        for (int i = 0; i < 10001; i ++){
            ara[i] = i;
        }

        for (int i = 2; i < 10001; i ++){
            int idx = i + i;
            while(idx < 10000){
                ara[idx] = 0;
                idx += i;
            }
        }

        int n = Integer.parseInt(br.readLine());


        for (int i = 0; i < n; i++) {
            int inp = Integer.parseInt(br.readLine());
            int p1 = 0;
            int p2 = 0;

            if (inp % 2 == 0){
                p1 = inp / 2;
                p2 = inp / 2; 
            }
            else{
                p1 = inp / 2;
                p2 = (inp + 1) / 2;
            }
            while(true){
                if((ara[p1] * ara[p2]) != 0) {
                    System.out.println(ara[p1] + " " + ara[p2]);
                    break;
                }
                else{
                    p1 --;
                    p2 ++;
                }
            }

            // ArrayList<Integer> primeNum = new ArrayList<Integer>();
            // primeNum.add(0);
            // for (int idx = 2; idx < inp ; idx ++){
            //     if(ara[idx] != 0) primeNum.add(ara[idx]);
            // }

            // // 가운데부터 연산
            // int mid = primeNum.size() / 2;
            // int p1 = mid -1;
            // int p2 = mid;
            // while(true){
            //     if(primeNum.get(p1) + primeNum.get(p2) == inp){
            //         System.out.println(primeNum.get(p1) + " " + primeNum.get(p2));
            //         break;
            //     }
            //     else{
            //         if(primeNum.get(p1) + primeNum.get(p2) > inp){
            //             p1 --;
            //         }
            //         else p2 ++;
            //     }
            // }
        }
    }

}