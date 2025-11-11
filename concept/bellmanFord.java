// 가중치가 있는 그래프에서 단일 출발점(Single Source) 기준 최단 거리를 구하는 알고리즘
// 음수 간선이 있어도 사용 가능
// 음수 사이클(Negative Cycle) 검출 가능
// 예시: 통신 비용 계산에서 음수 가중치(리베이트, 환불 등)가 있는 경우, 금융 거래에서 최단 경로 계산 시 음수 거래 수수료 반영

// Dynamic Programming 기반
// 모든 간선을 최대 (V-1)번 반복하여 최단 거리 갱신
// 마지막 반복에서 거리 갱신이 발생하면 음수 사이클 존재
// Greedy 기반인 다익스트라와 달리 음수 간선을 처리 가능

import java.util.*;

class Edge {
    int from, to, weight;
    Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    } // constructor
} // class

public class BellmanFord {
    static final int INF = Integer.MAX_VALUE;
    
    public static boolean bellmanFord(int V, List<Edge> edges, int start, int[] dist) {
        Arrays.fill(dist, INF);
        dist[start] = 0;
        
        // V-1번 반복
        for(int i=1; i<V; i++){
            for(Edge e : edges){
                if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.weight){
                    dist[e.to] = dist[e.from] + e.weight;
                } // if
            } // for - e
        } // for - i
        
        // 음수 사이클 확인
        for(Edge e : edges){
            if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.weight){
                return false; // 음수 사이클 존재
            } // if
        } // for - e
        return true; // 최단 거리 계산 완료
    } // bellmanFord
    
    public static void main(String[] args){
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 6));
        edges.add(new Edge(0, 2, 7));
        edges.add(new Edge(1, 2, 8));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(1, 4, -4));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(2, 4, 9));
        edges.add(new Edge(3, 1, -2));
        edges.add(new Edge(4, 3, 7));
        edges.add(new Edge(4, 0, 2));

        int[] dist = new int[V];
        if(bellmanFord(V, edges, 0, dist)){
            System.out.println(Arrays.toString(dist));
        } else {
            System.out.println("음수 사이클 존재");
        } // if ~ else
    } // main
} // class
