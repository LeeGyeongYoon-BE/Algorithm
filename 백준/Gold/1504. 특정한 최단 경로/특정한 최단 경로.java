import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v, w;
        Node(int v, int w) {
            this.v = v;
            this.w = w;
        } // constructor
        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        } // compare
    } // Node

    static final int INF = 987654321;
    static int N, E;
    static List<Node>[] graph;

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (cur.w > dist[cur.v]) continue;

            for (Node next : graph[cur.v]) {
                if (dist[next.v] > dist[cur.v] + next.w) {
                    dist[next.v] = dist[cur.v] + next.w;
                    pq.offer(new Node(next.v, dist[next.v]));
                } // if
            } // for
        } // while
        return dist;
    } // dijkstra

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        } // for

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] distFrom1 = dijkstra(1);
        int[] distFromV1 = dijkstra(v1);
        int[] distFromV2 = dijkstra(v2);

        long path1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[N];
        long path2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[N];

        long answer = Math.min(path1, path2);

        System.out.println(answer >= INF ? -1 : answer);
        
        br.close();
    } // main
} // class
