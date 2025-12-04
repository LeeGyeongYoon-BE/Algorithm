import java.io.*;
import java.math.BigInteger;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int from, int to, int aux) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, aux, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, aux, to, from);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 이동 횟수 = 2^N - 1 (N이 클 수 있어서 BigInteger 사용)
        BigInteger moves = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        System.out.println(moves);

        // N이 20 이하일 때만 실제 이동 과정 출력
        if (N <= 20) {
            hanoi(N, 1, 3, 2);
            System.out.print(sb);
        }
    }
}
