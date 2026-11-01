import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        while (n-- > 0) {
            for (int i = 0; i < m; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}