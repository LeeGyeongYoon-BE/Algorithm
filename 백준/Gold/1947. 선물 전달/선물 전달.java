import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1000000000;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long[] DP = new long[1000001];

        DP[0] = 0;
        DP[1] = 0;
        DP[2] = 1;

        for (int i = 3; i <= N; i++) {
            DP[i] = (i - 1) * (DP[i - 2] + DP[i - 1]) % MOD;
        } // for

        System.out.println(DP[N]);

    } // main
} // class
