import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 사람 수
        M = Integer.parseInt(st.nextToken()); // 친구 관계 수

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        } // for

        int answer = -1;
        int minValue = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int bacon = bfs(i); // i번 사람의 케빈 베이컨 수
            if (bacon < minValue) {
                minValue = bacon;
                answer = i;
            } // if
        } // for

        System.out.println(answer);
    } // main

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                } // if
            } // for
        } // while

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += dist[i];
        } // for
        return sum;
    } // bfs
} // class
