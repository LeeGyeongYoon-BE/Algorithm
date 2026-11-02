import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 위쪽 (별 증가)
        for (int i = 0; i < n; i++) {

            // 공백
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }

            // 별
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // 아래쪽 (별 감소)
        for (int i = n - 2; i >= 0; i--) {

            // 공백
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }

            // 별
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}