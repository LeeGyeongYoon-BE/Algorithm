import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[V + 1];

        List<int[]>[] graph = new List[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 1; i <= E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[from].add(new int[]{to,cost});
        } // for

        int[] dist = new int[V + 1];
        Arrays.fill(dist, 3000000);

        dist[start] = 0; // 시작 정점의 거리 : 0
        for (int i = 1; i <= V; i++) {
            int min = Integer.MAX_VALUE;
            int minVertex = -1;

            for (int j = 1; j <= V; j++) {
                if (!visited[j] && min > dist[j]) {
                    min = dist[j];
                    minVertex = j;
                } // if
            } // for - j

            if (minVertex == -1) {
                break; // 모든 순회를 끝마침
            } // if
            visited[minVertex] = true;

            for (int[] to : graph[minVertex]) {
                if ( !visited[to[0]] && dist[ to[0] ] > min + to[1]) {
                    dist[ to[0] ] = min + to[1];
                } // if
            } // for
        } // for - i

        for (int i = 1; i <= V; i++) {
            if ( dist[i] == 3000000 ){
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            } // if ~ else
        } // for

        br.close();
    } // main
} // class
