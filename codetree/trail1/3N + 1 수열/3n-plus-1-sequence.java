import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        int N = sc.nextInt();
        while (true) {

            if (N == 1) {
                break;
            }
            if (N % 2 != 0) {
                N = (3 * N) + 1;
                cnt++;
            } else {
                N /= 2;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}