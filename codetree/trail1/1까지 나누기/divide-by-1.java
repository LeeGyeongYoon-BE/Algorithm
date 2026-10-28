import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 1;
        for (int i = 1; i <= N; i++) {
            if (N / i <= 1) {
                break;
            } else {
                N /= i;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}