import java.io.*;
import java.util.*;

public class Main {
    static int N, M;                // 지도의 크기
    static int[][] map;             // 지도 정보 (0=바다, 1=땅 → 나중에 섬 번호로 변경)
    static boolean[][] visited;     // BFS 방문 체크
    static int[] parent;            // Union-Find 부모 배열
    static int islandCount = 0;     // 섬 개수

    // 상, 하, 좌, 우 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    // 간선 클래스 (다리)
    static class Edge implements Comparable<Edge> {
        int u, v, w; // u섬 → v섬, 다리 길이 w
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        } // Edge
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w; // 다리 길이가 짧은 것부터 우선
        } // compareTo
    } // class - Edge

    // BFS로 섬에 번호를 붙이는 함수
    static void bfs(int x, int y, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;
        map[x][y] = id; // 현재 위치를 섬 번호로 변경

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                // 범위 안이고 방문 안 했고, 땅(1)이라면
                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    map[nx][ny] = id; // 같은 섬이므로 같은 id 부여
                    q.offer(new int[]{nx, ny});
                } // if
            } // for
        } // while
    } // bfs

    // 모든 섬에 고유 번호를 붙이는 함수
    static void labelIslands() {
        visited = new boolean[N][M];
        int id = 2; // 섬 번호는 2부터 시작 (0=바다, 1=아직 방문 안 한 땅)
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) { // 아직 방문하지 않은 땅
                    bfs(i, j, id); // BFS로 섬 전체 탐색 후 번호 부여
                    id++;
                } // if
            } // for - j
        } // for - i
        islandCount = id - 2; // 섬 개수 저장
    } // labelIslands

    // 다리 후보(간선)들을 찾는 함수
    static List<Edge> buildEdges() {
        List<Edge> edges = new ArrayList<>();

        // 모든 좌표에서 다리 놓기 시도
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 1) { // 섬에서 시작하는 경우만
                    int start = map[i][j];

                    for (int d = 0; d < 4; d++) {
                        int nx = i;
                        int ny = j;
                        int len = 0; // 다리 길이

                        // 직선으로 나아감
                        while (true) {
                            nx += dx[d];
                            ny += dy[d];

                            // 범위를 벗어나면 종료
                            if (nx < 0 || ny < 0 || nx >= N || ny >= M) break;
                            // 같은 섬을 만나면 종료
                            if (map[nx][ny] == start) break;

                            if (map[nx][ny] == 0) {
                                // 바다이면 다리 길이 +1
                                len++;
                                continue;
                            } // if

                            if (map[nx][ny] != start) {
                                // 다른 섬을 만난 경우
                                if (len >= 2) {
                                    // 다리 길이가 2 이상일 때만 추가
                                    edges.add(new Edge(start, map[nx][ny], len));
                                } // if
                                break;
                            } // if
                        } // while
                    } // for - d
                } // if
            } // for - j
        } // for - i
        return edges;
    } // buildEdges

    // Union-Find - Find
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]); // 경로 압축
    } // find

    // Union-Find - Union
    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false; // 이미 같은 집합이면 실패
        parent[b] = a;
        return true;
    } // union

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        // 1. 섬에 번호 매기기
        labelIslands();

        // 2. 섬들 사이의 다리 후보(간선) 생성
        List<Edge> edges = buildEdges();

        // 3. MST (Kruskal + Union-Find)
        parent = new int[islandCount + 2];
        for (int i = 2; i < parent.length; i++) {
            parent[i] = i;
        } // for

        PriorityQueue<Edge> pq = new PriorityQueue<>(edges);
        int result = 0; // MST 비용 합
        int count = 0;  // 연결된 다리 개수

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.u, e.v)) { // 사이클이 생기지 않으면 선택
                result += e.w;
                count++;
                if (count == islandCount - 1) break; // MST 완성
            } // if
        } // while

        // 모든 섬이 연결되지 않았으면 -1
        if (count != islandCount - 1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        } // if ~ else
    } // main
} // class
