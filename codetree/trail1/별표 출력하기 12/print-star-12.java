import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0) {
                    System.out.print("* ");
                } else {
                    int start = 2 * (i / 2 + 1) - 1;

                    if (j >= start && (j - start) % 2 == 0) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}