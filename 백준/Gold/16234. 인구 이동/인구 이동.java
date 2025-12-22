import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R; // N : 배열 크기, L : Left 값, R : Right 값
    static int[][] map;
    static boolean[][] visited;

    static int[] pi = {-1, 1, 0, 0}; // plusi, plusj
    static int[] pj = {0, 0, -1, 1}; // pi와 pj가 합쳐져서 새로운 상대 좌표를 표현

    static int count; // 반복 회차
    static int sum; // 평균 값 측정을 위한 합계
    static List<int[]> coordinates; // 합계 대상 좌표 저장을 위한 리스트

    static boolean isRepeat; // while문 탈출 조건

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        isRepeat = true;
        while (isRepeat) {
            isRepeat = false;
            visited = new boolean[N][N];
            count++; // 1에서 시작

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if ( visited[i][j] ) {
                        continue;
                    } // if

                    sum = 0;
                    coordinates = new ArrayList<int[]>();

                    bfs(i, j);

                    int average = sum / coordinates.size();
                    for (int[] tmp : coordinates) {
                        map[ tmp[0] ][ tmp[1] ] = average;
                    } // for
                } // for - j
            } // for - i
        } // while

        System.out.println(count - 1);

        br.close();
    } // main

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<int[]>();
        q.offer(new int[]{i, j});
        coordinates.add(new int[]{i, j});
        visited[i][j] = true;
        sum += map[i][j];
        while (!q.isEmpty()) {
            int[] ij = q.poll();
            i = ij[0];
            j = ij[1];
            for (int k = 0; k < pi.length; k++) {
                int ni = i + pi[k];
                int nj = j + pj[k];

                if (ni < 0 || ni >= N || nj < 0 || nj >= N || visited[ni][nj]) {
                    continue;
                } // if

                int diff = Math.abs( map[i][j] - map[ni][nj]);
                if ( diff >= L && diff <= R ) {
                    q.offer(new int[]{ni, nj});
                    coordinates.add(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    sum += map[ni][nj];
                    isRepeat = true;
                } // if
            } // for
        } // while
    } // bfs
} // class
