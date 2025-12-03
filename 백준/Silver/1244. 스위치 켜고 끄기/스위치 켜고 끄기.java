import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] bright;

    static void swt(int i) {
        bright[i] = bright[i] == 0 ? 1 : 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bright = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            bright[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남학생
                for (int i = num; i <= N; i += num) {
                    swt(i);
                }
            } else { // 여학생
                swt(num); // 본인 스위치 먼저 변경
                for (int i = 1; num - i >= 1 && num + i <= N; i++) {
                    if (bright[num - i] == bright[num + i]) {
                        swt(num - i);
                        swt(num + i);
                    } else {
                        break;
                    }
                }
            }
        }

        // 20개씩 끊어서 출력
        for (int i = 1; i <= N; i++) {
            System.out.print(bright[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }
        }
        
    }
}