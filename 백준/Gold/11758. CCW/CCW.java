import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 세 점의 좌표 입력 받기
        int[][] point = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken()); // x좌표
            point[i][1] = Integer.parseInt(st.nextToken()); // y좌표
        }

        // CCW 공식 계산
        // (x1*y2 + x2*y3 + x3*y1) - (y1*x2 + y2*x3 + y3*x1)
        int ccw = (point[0][0] * point[1][1] + point[1][0] * point[2][1] + point[2][0] * point[0][1])
                - (point[0][1] * point[1][0] + point[1][1] * point[2][0] + point[2][1] * point[0][0]);

        // CCW 결과 해석
        // 양수 → 반시계 방향 (1)
        // 음수 → 시계 방향 (-1)
        // 0 → 일직선 (0)
        if (ccw > 0) {
            System.out.println(1);
        } else if (ccw < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }

        br.close();
    }
}
