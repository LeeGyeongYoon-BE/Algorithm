import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // Ai 증가하는 방향으로 이동하면
        // 차가 m 이상이 되는 쌍이 되는 Aj의 경계도 증가하는 방향으로 이동한다.
        int ansDiff = arr[n-1] - arr[0];
        int pairIndex = 0;
        for (int i = 0; i < n; i++) {
            while (arr[pairIndex] - arr[i] < m && pairIndex < n - 1){
                pairIndex++;
            }
            int diff = arr[pairIndex] - arr[i];
            if (diff >= m){
                ansDiff = Math.min(ansDiff, diff);
            }
        }
        System.out.println(ansDiff);
    }
}
