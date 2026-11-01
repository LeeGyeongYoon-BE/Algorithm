import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = n;
        while (cnt-- > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        cnt = n;
        while (cnt-- > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}