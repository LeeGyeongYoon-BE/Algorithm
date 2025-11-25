import java.io.*;
import java.util.*;

public class Main {
    static int[] select;
    static int[] visited;   // 방문 상태 (0: 미방문, 1: 방문중, 2: 방문완료)
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            select = new int[N + 1];
            visited = new int[N + 1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                select[i] = Integer.parseInt(st.nextToken());
            } // for

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    dfs(i);
                } // if
            } // for

            System.out.println(N - count);
        } // while
    } // main

    static void dfs(int cur) {
        visited[cur] = 1; // 방문중
        int next = select[cur];

        if (visited[next] == 0) {
            dfs(next);
        } else if (visited[next] == 1) {
            // 사이클 발견
            count++; // next부터 사이클 세기
            for (int i = next; select[i] != next; i = select[i]) {
                count++;
            } // for
        } // if ~ else

        visited[cur] = 2; // 방문완료
    } // dfs
} // class
