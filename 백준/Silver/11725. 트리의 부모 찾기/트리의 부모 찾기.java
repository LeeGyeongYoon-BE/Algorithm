import java.io.*;
import java.util.*;

class Main {
    public static List<Integer>[] tree;
    public static int[] parents;
    public static boolean[] check;

    public static void find(int node){
        check[node] = true;
        for (int i = 0; i < tree[node].size(); i++) {
            int child = tree[node].get(i);
            if (!check[child]) {
                parents[child] = node;
                find(child);
            }
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            tree[node1].add(node2);
            tree[node2].add(node1);
        }

        parents = new int[n+1];
        check = new boolean[n+1];

        find(1);
        for(int i = 2; i < n+1; i++){
            System.out.println(parents[i]);
        }
    }
}