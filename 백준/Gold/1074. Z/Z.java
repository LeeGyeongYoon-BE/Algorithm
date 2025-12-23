import java.io.*;
import java.util.*;

public class Main {
    static int N, R, C;
    static int [] pi = {0, 0, 1, 1}; // plusi, plusj
    static int [] pj = {0, 1, 0, 1}; // pi와 pj가 함쳐져서 새로운 상대 좌표를 표현

    private static void draw(int i, int j, int cnt, int size) {

        if( i > R || j > C ) return; // BackTracking

        if( i + size < R || j + size < C ) return; // BackTracking

        if( size == 2 ) {
            for (int k = 0; k < pi.length; k++) {
                int ni = i + pi[k];
                int nj = j + pj[k];
                if( ni == R && nj == C ) System.out.println( cnt + k );
            } // for
            return;
        } // 재귀 탈출

        // i : 0, j : 0, cnt : 0, size : 4 인 경우,
        draw(i,				j,			cnt + (size/2 * size/2 * 0), size/2); // 좌상 0, 0, 0, 2
        draw(i,				j + size/2,	cnt + (size/2 * size/2 * 1), size/2); // 우상 0, 2, 4, 2
        draw(i + size/2,	j,			cnt + (size/2 * size/2 * 2), size/2); // 좌하 2, 0, 8, 2
        draw(i + size/2,	j + size/2,	cnt + (size/2 * size/2 * 3), size/2); // 우하 2, 2, 12, 2
    } // draw

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        draw( 0, 0, 0, (int) Math.pow(2, N) ); // int i, int j, int cnt, int size

        br.close();
    } // main
} // class
