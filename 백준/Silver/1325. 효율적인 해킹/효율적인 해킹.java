import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static int N, M;
    static int[] visited;
    static int visitCnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // B -> A (B 해킹하면 A도 해킹 가능)
            graph[B].add(A);
        }

        visited = new int[N + 1];
        int[] result = new int[N + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);
            result[i] = cnt;
            if (cnt > max) max = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (result[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    static int bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        visitCnt++;
        visited[start] = visitCnt;
        q.add(start);
        int cnt = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (visited[next] != visitCnt) {
                    visited[next] = visitCnt;
                    q.add(next);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
