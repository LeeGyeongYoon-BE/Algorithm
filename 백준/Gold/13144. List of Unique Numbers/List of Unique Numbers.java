import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] appeared = new boolean[100001];
        long ansCount = 0;
        int nextIndex = 0;
        for (int i = 0; i < N; i++) {
            while (nextIndex < N) {
                if (appeared[arr[nextIndex]]) {
                    break;
                }
                appeared[arr[nextIndex++]] = true;
            }
            ansCount += nextIndex - i;
            appeared[arr[i]] = false;
        }
        sb.append(ansCount);
        System.out.println(sb);
    }
}
