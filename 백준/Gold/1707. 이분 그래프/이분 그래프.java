import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            A = new ArrayList[V + 1];
            check = new int[V + 1];
            visited = new boolean[V + 1];
            IsEven = true;
            for (int i = 1; i <= V; i++) {
                A[i] = new ArrayList<Integer>();
                visited[i] = false;
            }
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                A[start].add(end);
                A[end].add(start);
            }
            for (int i = 1; i <= V; i++) {
                if (IsEven && !visited[i]) {
                    check[i] = 0;
                    DFS(i);
                }
                if (!IsEven) {
                    break;
                }
            }
            if (IsEven) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static void DFS(int start) {
        visited[start] = true;
        if (!IsEven) {
            return;
        }
        for (int neighbor : A[start]) {
            if (!visited[neighbor]) {
                check[neighbor] = (check[start] + 1) % 2;
                DFS(neighbor);
                if (!IsEven) {
                    return;
                }
            } else if (check[neighbor] == check[start]) {
                IsEven = false;
                return;
            }
        }

    }
}

