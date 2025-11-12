import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 꼭짓점의 개수 입력

        long[] x = new long[N + 1]; // x좌표 배열
        long[] y = new long[N + 1]; // y좌표 배열

        // N개의 꼭짓점 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Long.parseLong(st.nextToken());
            y[i] = Long.parseLong(st.nextToken());
        }

        // 마지막 점에서 첫 번째 점으로 돌아가기 위해
        x[N] = x[0];
        y[N] = y[0];

        double area = 0; // 넓이 계산용 변수

        // 신발끈 공식 적용
        for (int i = 0; i < N; i++) {
            area += (x[i] * y[i + 1]) - (y[i] * x[i + 1]);
        }

        // 절댓값을 취하고 2로 나누어 실제 면적 계산
        area = Math.abs(area) / 2.0;

        // 소수점 첫째 자리까지 출력 (문제 요구사항)
        System.out.printf("%.1f\n", area);

        br.close();
    }
}
