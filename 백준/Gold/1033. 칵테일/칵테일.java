import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int to;
        int p, q;
        Node(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        } // Node
    } // class - Node

    static int N;
    static ArrayList<Node>[] graph;
    static long[] amount;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        long lcm = 1; // 모든 비율의 최소공배수
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Node(b, p, q));
            graph[b].add(new Node(a, q, p));

            lcm *= (p * q / gcd(p, q));
        } // for

        amount = new long[N];
        visited = new boolean[N];

        amount[0] = lcm;
        dfs(0);

        // 전체 최대공약수로 나누어 최소 정수 조합 만들기
        long mgcd = amount[0];
        for (int i = 1; i < N; i++) {
            mgcd = gcd(mgcd, amount[i]);
        } // for

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(amount[i] / mgcd).append(" ");
        } // for
        System.out.println(sb.toString());
    } // main

    static void dfs(int x) {
        visited[x] = true;
        for (Node n : graph[x]) {
            if (!visited[n.to]) {
                amount[n.to] = amount[x] * n.q / n.p;
                dfs(n.to);
            } // if
        } // for
    } // dfs

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    } // gcd
} // class
