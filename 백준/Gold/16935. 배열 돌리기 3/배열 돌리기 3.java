import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr, tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st =  new StringTokenizer(br.readLine());
        while( R-- > 0 ) {
            int order = Integer.parseInt(st.nextToken());
            if (order == 1){ // 상하 반전
                for (int i = 1; i <= N/2; i++){
                    for (int j = 1; j <= M; j++) {
                        int t = arr[i][j];
                        arr[i][j] = arr[N-i+1][j];
                        arr[N-i+1][j] = t;
                    }
                }
            } else if (order == 2){ // 좌우 반전
                for (int i = 1; i <= N; i++){
                    for (int j = 1; j <= M/2; j++){
                        int t = arr[i][j];
                        arr[i][j] = arr[i][M-j+1];
                        arr[i][M-j+1] = t;
                    }
                }
            } else if (order == 3){ // 오른쪽으로 90도 회전 // (x, y) -> (y, N-x+1)
                tmp = new int[M+1][N+1];
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        tmp[j][N-i+1] = arr[i][j];
                    }
                }
                arr = tmp;
                int t = N;
                N = M;
                M = t;
            } else if (order == 4){ // 왼쪽으로 90도 회전 // (x, y) -> (N-y+1, x)
                tmp = new int[M+1][N+1];
                for (int i = 1; i <= N; i++) {
                    for (int j = 1; j <= M; j++) {
                        tmp[M-j+1][i] = arr[i][j];
                    }
                }
                arr = tmp;
                int t = N;
                N = M;
                M = t;

            } else if (order == 5){ // 4개의 그룹을 오른쪽으로 한칸씩 이동
                tmp = new int[N+1][M+1];
                int n2 = N/2, m2 = M/2;

                // 1 -> 2
                for (int i=1; i<=n2; i++) {
                    for (int j=1; j<=m2; j++) {
                        tmp[i][j+m2] = arr[i][j];
                    }
                }
                // 2 -> 3
                for (int i=1; i<=n2; i++) {
                    for (int j=m2+1; j<=M; j++) {
                        tmp[i+n2][j] = arr[i][j];
                    }
                }
                // 3 -> 4
                for (int i=n2+1; i<=N; i++) {
                    for (int j=m2+1; j<=M; j++) {
                        tmp[i][j-m2] = arr[i][j];
                    }
                }
                // 4 -> 1
                for (int i=n2+1; i<=N; i++) {
                    for (int j=1; j<=m2; j++) {
                        tmp[i-n2][j] = arr[i][j];
                    }
                }
                arr = tmp;
            } else { // 4개의 그룹을 왼쪽으로 한칸씩 이동
                tmp = new int[N+1][M+1];
                int n2 = N/2, m2 = M/2;

                // 1 -> 4
                for (int i=1; i<=n2; i++) {
                    for (int j=1; j<=m2; j++) {
                        tmp[i+n2][j] = arr[i][j];
                    }
                }
                // 4 -> 3
                for (int i=n2+1; i<=N; i++) {
                    for (int j=1; j<=m2; j++) {
                        tmp[i][j+m2] = arr[i][j];
                    }
                }
                // 3 -> 2
                for (int i=n2+1; i<=N; i++) {
                    for (int j=m2+1; j<=M; j++) {
                        tmp[i-n2][j] = arr[i][j];
                    }
                }
                // 2 -> 1
                for (int i=1; i<=n2; i++) {
                    for (int j=m2+1; j<=M; j++) {
                        tmp[i][j-m2] = arr[i][j];
                    }
                }
                arr = tmp;

            } // if ~ else
        } // while

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

    } // main
} // class