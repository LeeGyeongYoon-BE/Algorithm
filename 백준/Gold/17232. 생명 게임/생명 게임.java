import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static int[][] getPrefixSum(char[][] map){
        int N = map.length - 1;
        int M = map[0].length - 1;
        int[][] acc = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int alive = (map[i][j] == '*' ? 1:0);
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + alive;
            }
        }
        return acc;
    }

    static int getRangeSum(int[][] acc, int r, int c, int k){
        int r1 = Math.max(r-k, 1);
        int c1 = Math.max(c-k, 1);
        int r2 = Math.min(r+k, acc.length - 1);
        int c2 = Math.min(c+k, acc[0].length - 1);
        return acc[r2][c2] - acc[r1-1][c2] - acc[r2][c1-1] + acc[r1-1][c1-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[][] map = new char[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            String rowMap = br.readLine();
            for (int j = 1; j <= M; j++) {
                map[i][j] = rowMap.charAt(j-1);
            }
        }
        while(T-- >0) {
            int[][] acc = getPrefixSum(map);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    int nearAlive = getRangeSum(acc, i, j, K);
                    if (map[i][j] == '*') {
                        nearAlive--;
                        if (nearAlive < A || B < nearAlive) {
                            map[i][j] = '.';
                        }
                    } else if (A < nearAlive && nearAlive <= B) {
                        map[i][j] = '*';
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        
    }
}
