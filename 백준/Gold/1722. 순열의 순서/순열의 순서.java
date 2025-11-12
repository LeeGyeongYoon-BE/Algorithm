import java.io.*;
import java.util.*;

public class Main {
    static long[] fact; // 팩토리얼 값을 저장할 배열 (최대 20!까지 가능)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 순열 크기
        fact = new long[N + 1]; // 팩토리얼 저장용
        fact[0] = 1;
        for (int i = 1; i <= N; i++) fact[i] = fact[i - 1] * i; // 미리 팩토리얼 계산

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cmd = Integer.parseInt(st.nextToken()); // 1 또는 2

        if (cmd == 1) {
            long K = Long.parseLong(st.nextToken()); // K번째
            boolean[] visited = new boolean[N + 1];  // 숫자 사용 여부 체크 (1~N)

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= N; i++) {
                // 아직 선택되지 않은 숫자들을 작은 것부터 하나씩 시도
                for (int j = 1; j <= N; j++) {
                    if (visited[j]) continue; // 이미 사용된 숫자는 패스

                    // 현재 자리에서 j를 선택하면, 뒤에는 (N-i)! 가지의 순열이 가능
                    if (fact[N - i] < K) {
                        // K가 더 크다면, j로 시작하는 블록을 건너뛴다
                        K -= fact[N - i];
                    } else {
                        // K가 fact[N-i] 이하라면, 이번 자리는 j로 확정
                        sb.append(j).append(" ");
                        visited[j] = true;
                        break;
                    } // if ~ else
                } // for - j
            } // - i
            System.out.println(sb);

        } else {
            int[] P = new int[N + 1];
            boolean[] visited = new boolean[N + 1]; // 숫자 사용 여부
            for (int i = 1; i <= N; i++) {
                P[i] = Integer.parseInt(st.nextToken());
            } // for

            long order = 1; // 몇 번째인지 저장 (1부터 시작)

            for (int i = 1; i <= N; i++) {
                // i번째 자리에 올 수 있는 후보 숫자들 중
                // 현재 P[i]보다 작은 수들 중 아직 안 나온 것들을 세기
                for (int j = 1; j < P[i]; j++) {
                    if (!visited[j]) {
                        order += fact[N - i]; // j가 선택되면 (N-i)! 개의 순열을 건너뜀
                    } // if
                } // for - j
                visited[P[i]] = true; // 현재 숫자는 사용 처리
            } // for - i

            System.out.println(order);
        } // if ~ else
    } // main
} // class
