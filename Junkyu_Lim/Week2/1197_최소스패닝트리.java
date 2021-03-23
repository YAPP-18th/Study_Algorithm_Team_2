import java.util.*;
import java.io.*;

public class mst {

    static int[] parents;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int result = 0;

        parents = new int[V+1];

        for(int i=0; i<V+1; i++) {
            parents[i] = i;
        }
        
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            pq.add(new Node(start, end, weight));
        }

        // for(Node node : pq)
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int p1 = find(node.start);
            int p2 = find(node.end);

            if(p1 == p2) continue;
            else {
                union(p1, p2);
                result += node.weight;
            }

        }
        System.out.println(result);
    }

    private static int find(int val){
        if(parents[val] == val) return val;
        else return parents[val] = find(parents[val]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x != y)
            parents[y] = x;
    }
}

class Node implements Comparable<Node>{
    int start;
    int end;
    int weight;
    
    public Node(int s, int e, int w) {
        this.start=s;
        this.end=e;
        this.weight=w;
    }
    
    @Override
    public int compareTo(Node n) { // 가중치 기준 오름차순 정렬
        return this.weight-n.weight;
    }
}