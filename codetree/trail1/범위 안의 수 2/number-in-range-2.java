import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int i = 10;
        double cnt = 0;
        double sum = 0;
        while (i-- > 0) {
            int a = sc.nextInt();

            if (a >= 0 && a <= 200) {
                cnt++;
                sum += a;
            }
        }

        System.out.printf("%d %.1f", (int) sum, sum / cnt);
    }
}