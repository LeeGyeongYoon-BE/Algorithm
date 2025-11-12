import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MOD = 1000000007;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][L + 1][R + 1];
        dp[1][1][1] = 1; // 초기값

        for (int n = 2; n <= N; n++) {
            for (int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    dp[n][l][r] = (dp[n - 1][l - 1][r]   // 왼쪽에 가장 큰 빌딩
                            + dp[n - 1][l][r - 1]   // 오른쪽에 가장 큰 빌딩
                            + dp[n - 1][l][r] * (n - 2)) % MOD; // 중간에 넣기
                } // for - r
            } // for - l
        } // for - n

        System.out.println(dp[N][L][R]);
        br.close();
    } // main
} // class
