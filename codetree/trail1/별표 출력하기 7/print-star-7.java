import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int cnt = 1;
        while (cnt <= n) {
            for (int i = 1; i <= cnt; i++) {
                System.out.print("* ");
            }
            cnt++;
            System.out.println();
        }
    }
}