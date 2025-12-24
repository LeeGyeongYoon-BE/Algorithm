import java.io.*;
import java.util.*;

public class Main {
    static int N, white, blue;
    static int [][] paper;
    private static void cut(int i, int j, int size) {
        int sum = 0;
        for (int row = i; row < i + size; row++) {
            for (int col = j; col < j + size; col++) {
                sum += paper[row][col];
            } // for - col
        } // for - row

        if( sum == 0 ) { // all white
            white++;
        } else if( sum == size * size ) { // all blue
            blue++;
        } else { // 섞여 있음 -> recursion
            // i : 0, j : 0, size : 8 인 경우,
            cut(i,			j,			size/2); // 좌상 0, 0, 4
            cut(i,			j + size/2,	size/2); // 우상 0, 4, 4
            cut(i + size/2,	j,			size/2); // 좌하 4, 0, 4
            cut(i + size/2,	j + size/2,	size/2); // 우하 4, 4, 4
        } // if ~ else
    } // cut
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i
        cut( 0, 0, N ); // int i, int j, int size

        System.out.println( white );
        System.out.println( blue );

        br.close();
    } // main
} // class
