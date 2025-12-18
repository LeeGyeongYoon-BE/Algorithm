import java.io.*;
import java.util.*;

public class Main {
    static int[] nodes;

    private static void union(int n1, int n2) {
        int pointer1 = find(n1);
        int pointer2 = find(n2);
        nodes[pointer1] = nodes[pointer2];
    } // union

    private static int find(int n) {
        if (nodes[n] == n) return n;
        return nodes[n] = find(nodes[n]);
    } // find

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        nodes = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodes[i] = i;
        } // for

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            union(n1, n2);
        } // for

        int[] schedule = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        } // for

        int count = 0;
        for (int i = 0; i < N - 1; i++) {
            if ( find(schedule[i]) != find(schedule[i+1])) {
                count++;
            } // if
        } // for

        System.out.println(count);
        br.close();
    } // main

} // class
