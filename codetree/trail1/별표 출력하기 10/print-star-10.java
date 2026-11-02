import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // 위쪽
        for (int i = 0; i < n; i++) {

            int count;

            if (i % 2 == 1) {
                count = n - (i - 1) / 2;
            } else {
                count = 1 + (i / 2);
            }

            for (int j = 0; j < count; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

        // 아래쪽 (위쪽을 역순으로 출력)
        for (int i = n - 1; i >= 0; i--) {

            int count;

            if (i % 2 == 1) {
                count = n - (i - 1) / 2;
            } else {
                count = 1 + (i / 2);
            }

            for (int j = 0; j < count; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}