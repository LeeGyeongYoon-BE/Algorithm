import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] a = new double[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextDouble();
        }
        
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        double avg = sum / n;
        System.out.printf("%.1f\n", avg);

        if (avg >= 4.0) {
            System.out.println("Perfect");
        } else if (avg >= 3.0) {
            System.out.println("Good");
        } else {
            System.out.println("Poor");
        }
    }
}