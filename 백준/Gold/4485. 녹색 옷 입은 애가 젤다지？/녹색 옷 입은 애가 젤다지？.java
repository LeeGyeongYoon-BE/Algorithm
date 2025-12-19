import java.io.*;
import java.util.*;

public class Main {
    static int[][] map, distance;
    static boolean[][] visited;
    static int[] pi = {-1, 1, 0, 0};
    static int[] pj = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            map = new int[N][N];
            distance = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    distance[i][j] = 987654321;
                } // for - j
            } // for - i

            distance[0][0] = map[0][0];

            for (int k = 0; k < N * N; k++) {
                int min = Integer.MAX_VALUE;
                int minI = 0;
                int minJ = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (!visited[i][j] && min > distance[i][j]) {
                            min = distance[i][j];
                            minI = i;
                            minJ = j;
                        }
                    } // for - j
                } // for - i

                visited[minI][minJ] = true;
                if( minI == N-1 && minJ == N-1 ) break; // 모든 순회를 끝마침

                for (int d = 0; d < pi.length; d++) {
                    int ni = minI + pi[d];
                    int nj = minJ + pj[d];

                    if (ni < 0 || ni >= N || nj < 0 || nj >= N) continue;

                    if (distance[ni][nj] > min + map[ni][nj]) {
                        distance[ni][nj] = min + map[ni][nj];
                    } // if
                } // for - d
            } // for - k

            System.out.println("Problem " + num + ": " + distance[N-1][N-1]);
            num++;
        } // while

        br.close();
    } // main
} // class