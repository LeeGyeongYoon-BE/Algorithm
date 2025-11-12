import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] colorCount = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 1; i <= M; i++) {
            int count = Integer.parseInt(st.nextToken());
            colorCount[i] = count;
            total += count;
        } // for
        int K = Integer.parseInt(br.readLine());
        double[][] D = new double[total + 1][total + 1];
        for (int i = 1; i <= total; i++) {
            D[i][1] = i;
            D[i][0] = 1;
            D[i][i] = 1;
        } // for

        for (int i = 2; i <= total; i++) {
            for (int j = 1; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            } // for - j
        } // for - i

        double ans = 0;
        for (int i = 1; i <= M; i++) {
            ans += D[colorCount[i]][K];
        } // for

        System.out.println(ans / D[total][K]);

        br.close();
    } // main
} // class
