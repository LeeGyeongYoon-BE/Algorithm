// 트리 구조에서 DP를 적용하는 알고리즘 기법
// 부모-자식 관계를 이용하여 문제를 작은 단위로 나누어 해결
// 일반적인 DP와 달리 선형 배열이 아닌 트리 구조에서 사용

// 트리는 사이클이 없으므로 DFS(깊이 우선 탐색)와 DP를 결합하여 계산
// 자식 노드의 결과를 부모 노드에서 합산하거나 선택적으로 사용
// 대표적인 문제:
// 트리의 독립 집합 최대 합 (노드를 선택할 때 인접 노드는 선택 불가)
// 트리에서 최단/최대 경로 계산

// 트리 독립 집합(노드 선택 문제)
import java.io.*;
import java.util.*;

public class TreeDP {
    static int N;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        dp = new int[N + 1][2]; // [0] 선택 안함, [1] 선택함
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) dp[i][1] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        } // for

        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    } // main

    static void dfs(int node) {
        visited[node] = true;
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += Math.max(dp[child][0], dp[child][1]);
                dp[node][1] += dp[child][0];
            } // if
        } // for
    } // dfs
} // class
