import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp = new int[31][31]; // 조합값 저장용 (최대 30C30)

    // 조합 함수: nCr
    public static int comb(int n, int r) {
        if (dp[n][r] > 0) return dp[n][r];
        if (n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 서쪽
            int M = Integer.parseInt(st.nextToken()); // 동쪽
            System.out.println(comb(M, N)); // M C N
        }
    }
}
