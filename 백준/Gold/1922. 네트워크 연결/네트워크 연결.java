import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        List<int[]>[] graph = new List[V+1];
        for (int i = 1; i <= V; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < E; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            graph[A].add(new int[]{B, C});
            graph[B].add(new int[]{A, C});
        } // for
        
        boolean [] visited = new boolean[ V + 1 ]; // 방문했던 정점 기록
        int [] minEdge = new int [ V + 1 ]; // 각 정점의 방문 비용 기록
        for (int i = 1; i <= V; i++) minEdge[i] = Integer.MAX_VALUE;

        PriorityQueue<int[]> que
                = new PriorityQueue<>( (o1, o2) -> Integer.compare( o1[1], o2[1]) ); // 가중치 비교 -> 정렬

        int sum = 0; // 최소 비용 합계
        int cnt = 0; // 반복문 탈출 조건 - 정점 순회 반복 횟수
        minEdge[1] = 0; // 시작 정점에서 시작 정점으로의 거리는 0
        que.offer( new int[] {1, 0} ); // 시작 정점에서 시작 정점으로의 거리는 0

        while ( !que.isEmpty() ) {
            int [] cur = que.poll();
            int minVertex = cur[0];
            int min = cur[1];

            if( visited[minVertex] ) continue;

            visited[minVertex] = true;
            sum += min;
            if( cnt++ == V ) break;

            for ( int[] ve : graph[minVertex] ) {
                if( !visited[ ve[0] ] && minEdge[ ve[0] ] > ve[1] ) {
                    minEdge[ ve[0] ] = ve[1];
                    que.offer( new int[] { ve[0], minEdge[ ve[0] ] } );
                } // if
            } // for
        } // while

        System.out.println( sum );

        br.close();
    } // main
} // class
