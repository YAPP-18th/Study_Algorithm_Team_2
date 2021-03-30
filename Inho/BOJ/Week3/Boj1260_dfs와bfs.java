package Study_Algorithm_Team_2.Inho.BOJ.Week3;
import java.util.*;
import java.io.*;
class Main {
    static ArrayList<Integer> [] list;
    static int n;
    static boolean[] check;
    static ArrayList<Integer> result = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList [n + 1];
        check = new boolean[n + 1];


        for(int i=1; i<=n; i++){
            list[i] = new ArrayList<Integer>();
        }
        
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1; i<=n; i++){
            Collections.sort(list[i]);
        }

        dfs(v);
        
        for(int i: result){
            bw.write(i+ " ");
        }
        
        check = new boolean[n+1];
        result = new ArrayList<Integer>();
        bw.write("\n");
        
        bfs(v);

        for(int i: result){
            bw.write(i+ " ");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    public static void dfs(int v){
        check[v] = true;
        result.add(v);
        for(int i: list[v]){
            if(!check[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue <Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        check[v] = true;

        while(!queue.isEmpty()){
            int i = queue.poll();
            result.add(i);

            for(int j: list[i]){
                if(!check[j]){
                    queue.add(j);
                    check[j] = true;
                }
            }
        }



    }
}