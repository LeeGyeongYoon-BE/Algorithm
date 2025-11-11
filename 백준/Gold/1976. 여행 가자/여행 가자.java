import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        } // for

        for (int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++){
                int match = Integer.parseInt(st.nextToken());
                if (match == 1){
                    union(i, j);
                } // if
            } // for - j
        } // for - i

        int[] city = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            city[i] = find(target);
        } // for

        boolean canGo = true;
        for (int i = 1; i < M; i++){
            if (city[0] != city[i]) {
                canGo = false;
            } // if
        } // for

        if (canGo){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        br.close();
    } // main

    private static void union(int a, int b) {
        // 대표노드 찾아서 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        } // if
    } // union

    private static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        } // if ~ else
    } // find

    private static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return true;
        } // if
        return false;
    } // checkSame

} // class
