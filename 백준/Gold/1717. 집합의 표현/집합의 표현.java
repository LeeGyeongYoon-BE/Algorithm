import java.io.*;
import java.util.*;
public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        while (M-- > 0){
            String[] s =  br.readLine().split(" ");
            int testCase =  Integer.parseInt(s[0]);
            int a = Integer.parseInt(s[1]);
            int b =  Integer.parseInt(s[2]);
            if (testCase == 0) {
                union(a, b);
            } else {
                boolean result = checkSum(a, b);
                if (result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    private static int find(int node) {
        if (node == parent[node]) {
            return node;
        } else {
            return parent[node] = find(parent[node]);
        }
    }
    private static boolean checkSum(int a, int b){
        a = find(a);
        b = find(b);
        if (a==b) {
            return true;
        }else {
            return false;
        }
    }
}