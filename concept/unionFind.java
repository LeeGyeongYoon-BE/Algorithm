// 서로소 집합(Disjoint Set)을 관리하는 자료구조
// 서로 다른 집합을 합치거나(Union), 같은 집합인지 확인(Find) 하는 연산을 빠르게 수행
// 그래프에서 연결 요소, 사이클 검출, MST(최소 신장 트리) 등에 자주 사용

// find(x) : 요소 x가 속한 집합의 대표를 찾음
// union(x) : 요소 x와 y가 속한 집합을 합침
// 같은 집합 확인 : find(x) == find(y)

// 최적화 기법
// 1. 경로 압축(Path Compression)
// find 수행 시, 방문한 노드를 루트에 바로 연결
// find 연산 속도를 거의 상수 시간으로 향상
// 2. 랭크/크기 기준 합치기(Union by Rank/Size)
// 트리 깊이를 최소화하기 위해 작은 트리를 큰 트리에 붙임
// 트리 균형 유지로 연산 속도 향상
// 경로 압축 + 랭크 최적화 → 거의 O(1) 수준의 성능

public class UnionFind {
    private int[] parent;
    private int[] rank; // 트리 깊이

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;
    } // constructor

    // 루트 찾기 + 경로 압축
    public int find(int x) {
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    } // find

    // 합치기 (랭크 기준)
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX == rootY) return;

        if(rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if(rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        } // if ~ else
    } // union

    // 같은 집합인지 확인
    public boolean connected(int x, int y) {
        return find(x) == find(y);
    } // connected
} // class
