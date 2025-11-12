import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000000; // K의 최대값 (1e9)
    static int N, M;
    static long[][] dp; // 조합(문자열 수) 저장 DP

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // a 개수
        M = Integer.parseInt(st.nextToken()); // z 개수
        int K = Integer.parseInt(st.nextToken()); // K번째

        dp = new long[N + M + 1][N + M + 1];
        for (int i = 0; i <= N + M; i++) {
            Arrays.fill(dp[i], -1);
        } // for

        // 만들 수 있는 전체 문자열 개수가 K보다 작으면 불가능
        if (comb(N + M, N) < K) {
            System.out.println(-1);
            return;
        } // if

        StringBuilder sb = new StringBuilder();
        findString(N, M, K, sb);
        System.out.println(sb);
    } // main

    // nCm (n개 중 m개 고르는 경우의 수)
    static long comb(int n, int m) {
        if (m == 0 || n == m) return 1;
        if (dp[n][m] != -1) return dp[n][m];

        long val = comb(n - 1, m - 1) + comb(n - 1, m);
        if (val > MAX) val = MAX + 1; // K 초과는 의미 없음, 안전하게 잘라줌
        return dp[n][m] = val;
    } // comb

    // 실제 K번째 문자열 구성
    static void findString(int n, int m, int k, StringBuilder sb) {
        if (n == 0) {
            for (int i = 0; i < m; i++) sb.append('z');
            return;
        } // if
        if (m == 0) {
            for (int i = 0; i < n; i++) sb.append('a');
            return;
        } // if

        // 맨 앞이 'a'일 경우의 수
        long leftCount = comb(n + m - 1, n - 1);

        if (k <= leftCount) {
            sb.append('a');
            findString(n - 1, m, k, sb);
        } else {
            sb.append('z');
            findString(n, m - 1, (int)(k - leftCount), sb);
        } // if ~ else
    } // findString
} // class
