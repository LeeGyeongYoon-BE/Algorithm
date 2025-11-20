import java.io.*;
import java.util.*;

class Main {
    static int[] parent;
    static int[] like;
    static List<Integer>[] tree;

    public static void next(int node){
        for (int i = 0; i < tree[node].size(); i++){
            int child = tree[node].get(i);
            like[child]+=like[node];
            next(child);
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        like = new int[n+1];
        tree = new ArrayList[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
            parent[i] = Integer.parseInt(st.nextToken());

            if (parent[i] != -1){
                tree[parent[i]].add(i);
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            like[employee] += point;
        }

        next(1);

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append(like[i]).append(" ");
        }
        System.out.println(sb);
    }

}