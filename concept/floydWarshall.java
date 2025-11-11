// 모든 정점 쌍(ALL-PAIRS) 최단 거리를 구하는 알고리즘
// 동적 계획법(Dynamic Programming) 기반
// 음수 간선도 처리 가능, 단 음수 사이클이 있으면 의미 없는 값이 발생
// 예시: 도시 간 최단 경로 계산, 통신망에서 모든 노드 간 최소 비용 계산

// 모든 정점 쌍 최단 거리 계산
// V^3 시간 복잡도 (O(V^3)) → 정점 수가 적을 때 사용 적합
// 음수 간선 처리 가능, 음수 사이클 검출 가능

import java.util.*;

public class FloydWarshall {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        int V = 4; // 정점 수
        int[][] dist = new int[V][V];

        // 초기화
        for(int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; // 자기 자신은 0
        } // for

        // 간선 입력 (예: from, to, weight)
        dist[0][1] = 5;
        dist[0][3] = 10;
        dist[1][2] = 3;
        dist[2][3] = 1;

        // 플로이드-워셜 알고리즘
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    } // if
                } // for - j
            } // for - i
        } // for - k

        // 결과 출력
        for(int i = 0; i < V; i++){
            for(int j = 0; j < V; j++){
                if(dist[i][j] == INF) System.out.print("INF ");
                else System.out.print(dist[i][j] + " ");
            } // for -j
            System.out.println();
        } // for - i
    } // main
} // class
