import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    public static int[] dS;
    public static int[] dA;
    public static int[] dB;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            graph.get(fare[0]).add(new Node(fare[1], fare[2]));
            graph.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        dS = new int[n+1];
        dA = new int[n+1];
        dB = new int[n+1];

        Arrays.fill(dS, Integer.MAX_VALUE);
        Arrays.fill(dA, Integer.MAX_VALUE);
        Arrays.fill(dB, Integer.MAX_VALUE);

        dijkstra(s, dS);
        dijkstra(a, dA);
        dijkstra(b, dB);

        int answer = Integer.MAX_VALUE;
        
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, dS[i] + dA[i] + dB[i]);
        }

        return answer;
    }
    
    public void dijkstra(int start, int[] d) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int idx = node.index;
            int dist = node.distance;

            if (dist > d[idx]) continue;
            for (int i = 0; i < graph.get(idx).size(); i++) {
                int cost = d[idx] + graph.get(idx).get(i).distance;

                if (cost < d[graph.get(idx).get(i).index]){
                    d[graph.get(idx).get(i).index] = cost;
                    pq.offer(new Node(graph.get(idx).get(i).index, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node>{
    int index;
    int distance;
    
    public Node(int index, int distance){
        this.index = index;
        this.distance = distance;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.distance - other.distance;
    }
}
