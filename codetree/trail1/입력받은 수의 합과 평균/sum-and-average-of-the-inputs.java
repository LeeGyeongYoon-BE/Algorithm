import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double cnt = N;
        double sum = 0;

        while (N-- > 0) {
            sum += sc.nextInt();
        }

        System.out.printf("%d %.1f", (int) sum, sum / cnt);
    }
}