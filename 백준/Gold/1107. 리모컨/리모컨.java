import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static boolean canMake(int num, boolean[] broken) {
        if (num == 0) return !broken[0];
        while (num > 0) {
            if (broken[num % 10]) return false;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        boolean[] broken = new boolean[10];
        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int answer = Math.abs(N - 100); // +,- 만 사용
        for (int i = 0; i <= 999999; i++) {
            if (canMake(i, broken)) {
                int pressCount = String.valueOf(i).length() + Math.abs(N - i);
                answer = Math.min(answer, pressCount);
            }
        }

        System.out.println(answer);
    }
}
