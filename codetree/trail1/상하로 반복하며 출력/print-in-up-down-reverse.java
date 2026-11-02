import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            int num1 = i;
            int num2 = n - i + 1;

            for (int j = 0; j < n; j++) {
                if (j % 2 == 0) {
                    System.out.print(num1);
                } else {
                    System.out.print(num2);
                }
            }

            System.out.println();
        }
    }
}