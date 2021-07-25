package Programmers.YAPP.Week17;

import java.util.*;

public class 합승택시요금 {
    static class Solution {
        //최대값 = 최대 지점 갯수 200 * 최대 요금 100,000 + 1
        public final int MAX_VAL = 20000001;
        class Graph {
            public int n;
            //인접 노드
            List<Edge>[] adj;
            //minCost[시작점][도착점] = 최소 비용
            public int[][] minCost;

            private Graph(int n) {
                this.n = n;
                minCost = new int[n + 1][n + 1];
                adj = new ArrayList[n + 1];
                for(int i = 1; i < n + 1; ++i){
                    adj[i] = new ArrayList<>();
                    Arrays.fill(minCost[i], MAX_VAL);
                    minCost[i][i] = 0;
                }
            }

            class Edge implements Comparable<Edge> {
                public int v;
                public int cost;
                public Edge(int v, int cost) {
                    this.v = v;
                    this.cost = cost;
                }

                @Override
                //PriorityQueue에서 정렬을 위한 compareTo 메서드
                public int compareTo(Edge o) {
                    return Integer.compare(this.cost, o.cost);
                }
            }

            private void addEdge(int v1, int v2, int cost){
                // 지점 v1, v2끼리 연결
                adj[v1].add(new Edge(v2, cost));
                adj[v2].add(new Edge(v1, cost));
            }

            private void dijkstra(int start) {
                PriorityQueue<Edge> pq = new PriorityQueue<>();
                pq.add(new Edge(start, 0));
                while (!pq.isEmpty()) {
                    Edge now = pq.poll(); // pq에서 가장 cost가 작은 Edge를 poll
                    // 현재 지점에서의 요금이 최소 비용 배열 값에 있는 요금보다 크다면
                    if (minCost[start][now.v] < now.cost) continue;
                    for (Edge next : adj[now.v]) {
                        //인접 지점으로 가는 요금이 기존에 계산했던 최소 비용보다 작다면 업데이트
                        if (minCost[start][next.v] > minCost[start][now.v] + next.cost) {
                            minCost[start][next.v] = minCost[start][now.v] + next.cost;
                            pq.add(next);
                        }
                    }
                }
            }
        }

        public int solution(int n, int s, int a, int b, int[][] fares) {
            // 그래프를 만들고 지점과 지점을 연결해줌
            Graph g = new Graph(n);
            for(int[] fare : fares){
                g.addEdge(fare[0], fare[1], fare[2]);
            }
            //각각 다익스트라 알고리즘을 통해 시작점, A의 도착지점, B의 도착지점에서 모든 지점까지의 최소 비용을 구함
            g.dijkstra(s);
            g.dijkstra(a);
            g.dijkstra(b);

            int answer = Integer.MAX_VALUE;

            for(int i = 1; i < n + 1; ++i){ // 특정 지점 i에서 s, a, b까지 가는데 비용이 최쇤 점을 구한다.
                answer = Math.min(answer, g.minCost[s][i] + g.minCost[a][i] + g.minCost[b][i]);
            }
            return answer;
        }
    }
}