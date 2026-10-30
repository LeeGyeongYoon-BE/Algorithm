import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.

        Scanner sc = new Scanner(System.in);

        double cnt = 0;
        double sum = 0;

        while (true) {
            double a = sc.nextDouble();

            if (a >= 30 || a < 20) {
                System.out.printf("%.2f", sum / cnt);
                break;
            } else {
                sum += a;
                cnt++;
            }
        }
    }
}