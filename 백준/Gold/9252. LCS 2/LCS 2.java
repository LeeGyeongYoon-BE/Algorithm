import java.io.*;
import java.util.*;

public class Main {
    static char[] A, B;
    static int[][] DP;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        int n = A.length;
        int m = B.length;

        DP = new int[n + 1][m + 1];

        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] == B[j - 1]) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                } // if ~ else
            } // for - j
        } // for - i

        System.out.println(DP[n][m]);  // LCS 길이 출력

        // LCS 문자열 추적
        getText(n, m);

        System.out.println(sb.reverse().toString());
    } // main

    // LCS 문자열 복원
    static void getText(int r, int c) {
        if (r == 0 || c == 0) return;

        if (A[r - 1] == B[c - 1]) {
            sb.append(A[r - 1]);
            getText(r - 1, c - 1);
        } else {
            if (DP[r - 1][c] > DP[r][c - 1]) {
                getText(r - 1, c);
            } else {
                getText(r, c - 1);
            } // if ~ else
        } // if ~ else
    } // getText
} // class
