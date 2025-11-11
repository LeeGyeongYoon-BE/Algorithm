import java.io.*;
import java.util.*;

public class Main {
    // 간선 정보 저장용 클래스 (u, v 정점과 가중치 w)
    static class Edge implements Comparable<Edge> {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        } // Edge

        @Override
        public int compareTo(Edge o) {
            return this.w - o.w; // 가중치 기준 오름차순 정렬
        } // compareTo
    } // class - Edge

    static int[] parent; // Union-Find 부모 배열

    // find 연산 (경로 압축 적용)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    } // find

    // union 연산 (두 집합을 하나로 합침)
    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return false; // 이미 같은 집합이면 연결 불필요
        parent[pb] = pa; // pb의 부모를 pa로 설정
        return true;
    } // union

    // 문자를 숫자로 변환
    static int charToLen(char c) {
        if (c == '0') return 0;           // 0은 연결 없음
        if ('a' <= c && c <= 'z') return c - 'a' + 1;   // a~z → 1~26
        return c - 'A' + 27;              // A~Z → 27~52
    } // charToLen

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 컴퓨터 개수

        List<Edge> edges = new ArrayList<>();
        int total = 0; // 전체 케이블 길이 합

        // 그래프 입력 받기
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                int len = charToLen(line.charAt(j - 1));
                total += len; // 전체 케이블 길이에 추가
                if (i != j && len > 0) {
                    // 자기 자신이 아니고, 케이블이 있으면 간선 추가
                    edges.add(new Edge(i, j, len));
                } // if
            } // for - j
        } // for - i

        // Union-Find 초기화
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 간선을 가중치 기준으로 정렬
        Collections.sort(edges);

        int mstCost = 0;   // MST 비용
        int count = 0;     // MST에 포함된 간선 개수

        // 크루스칼 알고리즘
        for (Edge e : edges) {
            if (union(e.u, e.v)) { // 사이클이 안 생기는 간선만 선택
                mstCost += e.w;
                count++;
                if (count == N - 1) break; // MST 완성되면 종료
            } // if
        } // for

        // 모든 컴퓨터가 연결됐는지 확인
        if (count != N - 1) {
            System.out.println(-1); // MST 불가능 (모든 노드 연결 실패)
        } else {
            System.out.println(total - mstCost);
            // 전체 케이블 합 - MST 비용 = 절약할 수 있는 길이
        } // if ~ else
    } // main
} // class
