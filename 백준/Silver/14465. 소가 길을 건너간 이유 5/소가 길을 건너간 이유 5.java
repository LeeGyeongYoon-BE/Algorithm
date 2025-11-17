import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] isBroken = new boolean[N + 1];
        while(B-- >0){
            int idx = Integer.parseInt(br.readLine());
            isBroken[idx] = true;
        }

        int currentBrokenCount = 0;
        for (int i = 1; i <= K; i++){
            if (isBroken[i]){
                currentBrokenCount++;
            }
        }
        int ans = currentBrokenCount;
        for (int i = 2; i <= N-K+1; i++){
            if (isBroken[i-1]){
                currentBrokenCount--;
            }
            if (isBroken[i+K-1]){
                currentBrokenCount++;
            }
            ans = Math.min(ans, currentBrokenCount);
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
