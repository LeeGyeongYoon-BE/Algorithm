import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] delta = new int[n + 2];
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            delta[a] += k;
            delta[b + 1] -= k;
        }
        int[] accDelta = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            accDelta[i] = accDelta[i - 1] + delta[i];
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + accDelta[i] + " ");
        }
        System.out.println();
    }
}
