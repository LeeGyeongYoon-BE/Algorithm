import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku = new int[9][9];
    static List<int[]> coordinates = new ArrayList<>(); // 0이 있는 좌표 모음
    static boolean returnFlag = false;

    private static boolean isMissing(int row, int col, int target) {
        // 0이 들어있는 좌표에 대입 가능한 수 찾기

        for (int i = 0; i < sudoku.length; i++) {
            if( sudoku[i][col] == target || sudoku[row][i] == target ) return false;
        } // for - 가로, 세로 검사

        row = row / 3 * 3; // 0이 있는 좌표의 9칸 계산을 위한 row, col 초기화
        col = col / 3 * 3; // 0,1,2->0 // 3,4,5->3 // 6,7,8->6

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if( sudoku[row + i][col + j] == target ) return false;
            } // for - j
        } // for - i

        return true;
    } // isMissing - backtracking

    private static void dfs(int idx) {
        if( returnFlag ) return;

        if( idx >= coordinates.size() ) {

            for (int[] line : sudoku) {
                for (int tmp : line) {
                    System.out.print(tmp + " ");
                } // for
                System.out.println();
            } // for

            returnFlag = true;

            return;
        } // 재귀 탈출

        int [] coord = coordinates.get(idx); // 0이 들어있는 좌표
        int i = coord[0];
        int j = coord[1];

        for( int target = 1; target < 10; target++ ) { // 수도쿠의 수 1에서 9까지

            if( isMissing(i, j, target) ) {
                sudoku[i][j] = target;
                dfs(idx + 1);
                sudoku[i][j] = 0;
            } // if

        } // for
    } // dfs

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = scan.nextInt();
                if( sudoku[i][j] == 0 ) coordinates.add( new int[]{i,j} );
            } // for - j
        } // for - i

        dfs(0);

        scan.close();
    } // main
} // class
