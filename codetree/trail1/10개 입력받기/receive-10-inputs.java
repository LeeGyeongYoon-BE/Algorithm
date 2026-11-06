import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        double[] a = new double[10];
        double cnt = 0;

        for (int i = 0; i < 10; i++) {
            double k = sc.nextDouble();

            if (k == 0) {
                break;
            } else {
                a[i] = k;
                cnt++;
            }
        }

        double sum = 0;

        for (int j = 0; j < cnt; j++) {
            sum += a[j];
        }

        System.out.printf("%.0f %.1f", sum, sum / cnt);
    }
}