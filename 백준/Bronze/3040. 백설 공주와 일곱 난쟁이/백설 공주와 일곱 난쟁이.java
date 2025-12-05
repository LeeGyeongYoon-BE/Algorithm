import java.io.*;
import java.util.*;

public class Main {
    static int N, R;
    static int[] input;
    static int[] number;
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9; // 전체 난쟁이 수
        R = 7; // 뽑을 난쟁이 수
        input = new int[N];
        number = new int[R];

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        combination(0, 0);
    }

    private static void combination(int idx, int start) {
        if (found) return; // 이미 정답 찾았으면 종료

        if (idx == R) {
            int sum = 0;
            for (int i = 0; i < R; i++) sum += number[i];
            if (sum == 100) {
                for (int i = 0; i < R; i++) {
                    System.out.println(number[i]);
                }
                found = true; // 정답 찾음
            }
            return;
        }

        for (int i = start; i < N; i++) {
            number[idx] = input[i];
            combination(idx + 1, i + 1);
        }
    }
}
