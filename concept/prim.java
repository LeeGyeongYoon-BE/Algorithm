// 최소 신장 트리(MST, Minimum Spanning Tree)를 구하는 알고리즘
// 그리디(Greedy) 기반으로 현재 트리에 인접한 간선 중 가장 작은 가중치를 선택하여 확장
// 크루스칼과 달리 정점 중심으로 MST를 확장
// 예시: 전력망, 도로, 통신망 등 연결 비용 최소화, 크루스칼과 유사하지만, 정점 중심으로 접근

// 최소 신장 트리 구성 → 모든 정점 연결, 사이클 없음
// 그리디 선택: 트리에 포함된 정점과 인접한 간선 중 최소 가중치 선택
// 우선순위 큐(PriorityQueue)를 사용하면 효율적

import java.util.*;

class Edge implements Comparable<Edge> {
    int to, weight;
    Edge(int to, int weight){
        this.to = to;
        this.weight = weight;
    } // constructor
    
    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
    } // compare
} // Edge

public class Prim {
    public static void main(String[] args) {
        int V = 4; // 정점 수
        List<Edge>[] graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
        
        // 예시 간선 추가 (양방향)
        graph[1].add(new Edge(2, 5));
        graph[2].add(new Edge(1, 5));
        graph[1].add(new Edge(3, 3));
        graph[3].add(new Edge(1, 3));
        graph[2].add(new Edge(3, 2));
        graph[3].add(new Edge(2, 2));
        graph[3].add(new Edge(4, 7));
        graph[4].add(new Edge(3, 7));
        
        boolean[] visited = new boolean[V+1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        pq.add(new Edge(1, 0)); // 시작 정점
        int mstWeight = 0;
        
        while(!pq.isEmpty()){
            Edge current = pq.poll();
            if(visited[current.to]) continue;
            visited[current.to] = true;
            mstWeight += current.weight;
            
            for(Edge e : graph[current.to]){
                if(!visited[e.to]){
                    pq.add(e);
                } // if
            } // for
        } // while
        
        System.out.println("MST 총 가중치: " + mstWeight);
    } // main
} // class
