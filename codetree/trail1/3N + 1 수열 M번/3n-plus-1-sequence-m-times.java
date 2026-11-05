import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        while (m-- > 0) {
            int N = sc.nextInt();
            int cnt = 0;
            while (N != 1) {
                if (N % 2 == 0) {
                    N /= 2;
                    cnt++;
                } else {
                    N = 3 * N + 1;
                    cnt++;
                }
            }
            System.out.println(cnt);
        }
    }
}