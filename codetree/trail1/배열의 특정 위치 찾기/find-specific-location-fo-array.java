import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        double[] a = new double[11];

        for (int i = 1; i <= 10; i++) {
            a[i] = sc.nextDouble();
        }
        
        double sum_2 = 0;
        double sum_3 = 0;
        double cnt = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sum_2 += a[i];
            }
            if (i % 3 == 0) {
                sum_3 += a[i];
                cnt++;
            }
        }

        System.out.printf("%.0f %.1f", sum_2, sum_3/cnt);
    }
    
}