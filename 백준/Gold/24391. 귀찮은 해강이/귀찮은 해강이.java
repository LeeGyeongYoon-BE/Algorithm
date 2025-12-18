import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] parent;
    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (b != a) {
            parent[b] = a;
        } // if
    } // union

    private static int find(int node){
        if (node == parent[node]){
            return node;
        } // if

        return parent[node] = find(parent[node]);
    } // find

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        while (M --> 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        } // while

        st = new StringTokenizer(br.readLine());
        int count = 0;
        int target = find(Integer.parseInt(st.nextToken()));
        for (int i = 0; i < N - 1; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(next) != target) {
                count++;
                target = find(next);
            } // if
        } // for

        System.out.println(count);

        br.close();
    } // main


} // class
