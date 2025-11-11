// 최소 신장 트리(MST, Minimum Spanning Tree)를 구하는 대표적인 알고리즘
// 그리디(Greedy) 알고리즘 기반
// 모든 간선을 가중치 오름차순으로 정렬한 후, 사이클이 생기지 않도록 간선을 선택
// 예시: 네트워크 비용 최소화, 도로, 전력망, 통신망 등 연결 비용 최적화

// 최소 신장 트리 구성 → 모든 정점 연결, 사이클 없음
// 그리디 선택: 항상 현재 가장 가중치가 작은 간선을 선택
// 구현 시 유니온-파인드(Union-Find, Disjoint Set) 자료구조 사용

import java.util.*;

class Edge implements Comparable<Edge> {
    int from, to, weight;
    Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    } // constructor

    @Override
    public int compareTo(Edge o){
        return this.weight - o.weight;
    } // compare
} // Edge

public class Kruskal {
    static int[] parent;

    static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    } // find

    static boolean union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return false;
        parent[b] = a;
        return true;
    } // union

    public static void main(String[] args) {
        int V = 4; // 정점 수
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 2, 5));
        edges.add(new Edge(1, 3, 3));
        edges.add(new Edge(2, 3, 2));
        edges.add(new Edge(3, 4, 7));

        Collections.sort(edges); // 가중치 기준 오름차순 정렬

        parent = new int[V+1];
        for(int i = 1; i <= V; i++) parent[i] = i;

        int mstWeight = 0;
        for(Edge e : edges){
            if(union(e.from, e.to)){
                mstWeight += e.weight;
            } // if
        } // for

        System.out.println("MST 총 가중치: " + mstWeight);
    } // main
} // class
