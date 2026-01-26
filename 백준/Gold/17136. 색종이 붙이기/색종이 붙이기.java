import java.io.*;
import java.util.*;

class Main
{
    static int[][] M = new int[10][10];
    static int[] S = {0, 5, 5, 5, 5, 5};
    static int result = Integer.MAX_VALUE;

    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                M[i][j] = Integer.parseInt(st.nextToken());
            } // for - j
        } // for - i

        backtracking(0, 0); // 좌표, 색종이 몇개
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        } // if ~ else

        br.close();
    } // main

    private static void backtracking(int xy, int useCnt) {
        if (xy == 100) {
            result = Math.min(result, useCnt);
            return;
        } // if
        int x = xy % 10;
        int y = xy / 10;

        // 가지치기
        if (result <= useCnt) return;
        if (M[y][x] == 1) {
            for (int i = 5; i > 0; i--){
                if (S[i] > 0 && check(x, y, i)) {
                    S[i]--;
                    fill(x, y, i, 0);
                    backtracking(xy + 1, useCnt + 1);
                    fill(x, y, i ,1);
                    S[i]++;
                } // if
            } // for
        } else {
            backtracking(xy + 1, useCnt);
        } // if ~ else
    } // backtracking


    private static void fill(int x, int y, int size, int num) {
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                M[i][j] = num;
            } // for - j
        } // for - i
    } // fill

    private static boolean check(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (M[i][j] != 1) return false;
            } // for - j
        } // for - i
        return true;
    } // check

} // class