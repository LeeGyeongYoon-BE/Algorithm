import java.io.*;
import java.util.*;

public class Main {

    static int N, A, B, M;
    static ArrayList<Integer>[] family;
    static boolean[] visited;
    static int count = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        family = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            family[i] = new ArrayList<>();
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            family[a].add(b);
            family[b].add(a);
        } // for

        dfs(A, 0);
        System.out.println(count);

        br.close();
    } // main

    private static void dfs(int start, int depth) {
        visited[start] = true;

        if (start == B) {
            count = depth;
            return;
        } // if

        for (int next : family[start]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
            } // if
        } // for
    } // dfs
} // class
