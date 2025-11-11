// 가중치가 있는 그래프에서 단일 출발점(Single Source) 기준 최단 거리를 구하는 알고리즘
// 음수 가중치가 없는 그래프에서 사용 가능
// 예시: 지도에서 출발지에서 다른 모든 지점까지 최소 이동 거리 계산, 네트워크 패킷 전송 경로 최적화

// Greedy 기반 알고리즘
// 음수 간선이 존재하면 사용할 수 없음 (벨만-포드 알고리즘 사용)
// 구현 방법에 따라 시간 복잡도가 달라짐

// 우선순위 큐 사용(Priority Queue, Heap)
// 현재 최단 거리가 가장 짧은 노드를 선택
// 인접 노드 거리 갱신
import java.util.*;

class Node implements Comparable<Node> {
    int vertex, weight;
    Node(int vertex, int weight){
        this.vertex = vertex;
        this.weight = weight;
    } // constructor
    public int compareTo(Node o){
        return this.weight - o.weight;
    } // compare
} // Node

public class Dijkstra {
    static final int INF = Integer.MAX_VALUE;
    
    public static void dijkstra(int start, List<Node>[] graph, int[] dist){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));
        
        while(!pq.isEmpty()){
            Node current = pq.poll();
            int u = current.vertex;
            int w = current.weight;
            
            if(dist[u] < w) continue;
            
            for(Node next : graph[u]){
                if(dist[next.vertex] > dist[u] + next.weight){
                    dist[next.vertex] = dist[u] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                } // if
            } // for
        } // while
    } // dijkstra

    public static void main(String[] args){
        int n = 5; // 노드 수 예시
        List<Node>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) graph[i] = new ArrayList<>();
        
        // 예시 간선 추가 (u, v, w)
        graph[0].add(new Node(1, 2));
        graph[0].add(new Node(2, 5));
        graph[1].add(new Node(2, 1));
        graph[1].add(new Node(3, 2));
        graph[2].add(new Node(3, 3));
        graph[3].add(new Node(4, 1));

        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        
        dijkstra(0, graph, dist);
        System.out.println(Arrays.toString(dist)); // 시작점 0에서 각 노드까지 최단 거리
    } // main
} // class
