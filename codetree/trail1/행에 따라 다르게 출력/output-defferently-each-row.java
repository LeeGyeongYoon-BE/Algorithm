import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int num = 1;

        for (int i = 0; i < n; i++) {

            int add = 1;

            if (i % 2 == 1) {
                add = 2;
            }

            for (int j = 0; j < n; j++) {
                System.out.print(num + " ");

                if (j < n - 1) {
                    num += add;
                }
            }

            // 다음 행의 시작 숫자 조정
            if (i % 2 == 0) {
                num += 2;
            } else {
                num += 1;
            }

            System.out.println();
        }
    }
}