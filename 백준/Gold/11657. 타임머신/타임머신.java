import java.io.*;
import java.util.*;

// bellman-ford
class Edge {
    int from, to, time;
    public Edge(int from, int to, int time) {
        this.from = from;
        this.to = to;
        this.time = time;
    } // Edge
} // class

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()); // from
            int B = Integer.parseInt(st.nextToken()); // to
            int C = Integer.parseInt(st.nextToken()); // time
            edges[i] = new Edge(A, B, C);
        } // for

        long [] distance = new long[N + 1]; // 1번도시부터 존재
        for (int i = 0; i <= N; i++) {
            distance[i] = Integer.MAX_VALUE;
        } // for

        distance[1] = 0; // 1번 도시가 출발도시
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) { // 모든 간선 확인
                Edge edge = edges[j];
                if( distance[edge.from] < Integer.MAX_VALUE ) {
                    if( distance[edge.to] > distance[edge.from] + edge.time ) {
                        distance[edge.to] = distance[edge.from] + edge.time;
                    } // if
                } // if
            } // for - j
        } // for - i // End of 벨만-포드

        boolean isCycled = false; // 음의 순환 확인
        for (int j = 0; j < M; j++) { // 모든 간선 확인
            Edge edge = edges[j];
            if( distance[edge.from] < Integer.MAX_VALUE ) {
                if( distance[edge.to] > distance[edge.from] + edge.time ) {
                    isCycled = true;
                } // if
            } // if
        } // for - j // End of 음의 순환

        if(isCycled) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if( distance[i] == Integer.MAX_VALUE ) {
                    System.out.println(-1);
                } else {
                    System.out.println( distance[i] );
                }
            } // for
        } // if ~ else

        br.close();
    } // main
} // class
