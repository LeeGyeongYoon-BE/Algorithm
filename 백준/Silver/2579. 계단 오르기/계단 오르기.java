import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] stairs = new int[N + 1]; // 계산의 개수
        int[] memoMax = new int[N + 1]; // max값을 저장하는 배열

        for (int i = 1; i <= N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        } // for

        memoMax[1] = stairs[1];

        // 2번지의 최대값의 경우의 수는 <1번지와 2번지의 합>
        if( N >= 2 ) memoMax[2] = stairs[1] + stairs[2];

        // 3번지의 최대값의 경우의 수는 <1번지와 2번지 중 큰 값>과 3번지의 합
        if( N >= 3 ) memoMax[3]
                = (stairs[1] >= stairs[2] ? stairs[1] : stairs[2]) + stairs[3];

        for (int i = 4; i <= N; i++) { // 3칸이 연속되면 안됨
            int a = memoMax[i - 2] + stairs[i];
            int b = memoMax[i - 3] + stairs[i - 1] + stairs[i];
            memoMax[i] = a >= b ? a : b;
        } // for

        System.out.println( memoMax[N] ); // 최대값 출력
        br.close();
    } // main
} // class
