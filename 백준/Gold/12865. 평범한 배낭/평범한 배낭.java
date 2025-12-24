import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        } // for
        int [] dp = new int[ K + 1 ]; // index : 가방의 kg, dp[7] : 7kg을 담았을 때의 최대 가치

        for (int i = 1; i <= N; i++) {
            for (int j = K; j - W[i] >= 0; j--) {
                dp[j] = Math.max( dp[j] , dp[ j - W[i] ] + V[i] );
            } // for - j
        } // for - i

        System.out.println( dp[K] );
        br.close();
    } // main
} // class
