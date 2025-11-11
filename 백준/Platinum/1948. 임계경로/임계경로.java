import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to, cost;
        Node(int to, int cost) {
            this.to = to; this.cost = cost;
        } // Node
    } // class - Node

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Node>[] adj = new ArrayList[N + 1];
        List<Node>[] reverseAdj = new ArrayList[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            reverseAdj[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj[from].add(new Node(to, cost));
            reverseAdj[to].add(new Node(from, cost));
            indegree[to]++;
        } // for

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int[] time = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();

        // 위상정렬 시작
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node next : adj[now]) {
                if (time[next.to] < time[now] + next.cost) {
                    time[next.to] = time[now] + next.cost;
                } // if
                indegree[next.to]--;
                if (indegree[next.to] == 0) q.offer(next.to);
            } // for
        } // while

        // 최장 경로 시간
        System.out.println(time[end]);

        // 역추적해서 사용된 간선 수
        boolean[] visited = new boolean[N + 1];
        q.offer(end);
        int count = 0;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (Node prev : reverseAdj[now]) {
                if (time[now] - prev.cost == time[prev.to]) {
                    count++;
                    if (!visited[prev.to]) {
                        visited[prev.to] = true;
                        q.offer(prev.to);
                    } // if
                } // if
            } // for
        } // while

        System.out.println(count);

        br.close();
    } // main
} // class
