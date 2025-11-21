import java.io.*;
import java.util.*;

public class Main {
    static int N, M, count;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        } // for

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        } // for

        count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                count++;
                dfs(i);
            } // if
        } // for

        System.out.println(count);
        br.close();
    } // main

    private static void dfs(int v) {
        visited[v] = true;
        for (int i : graph[v]) {
            if (!visited[i]) {
                dfs(i);
            } // if
        } // for
    } // dfs

} // class
