import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        double[] a = new double[10];

        for (int i = 0; i < 10; i++) {
            a[i] = sc.nextDouble();
        }

        double sum = 0;
        double cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (a[i] >= 250) {
                break;
            } else {
                sum += a[i];
                cnt++;
            }
        }

        System.out.printf("%.0f %.1f", sum, sum / cnt);


    }
}