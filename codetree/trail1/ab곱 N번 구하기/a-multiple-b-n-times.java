import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        while (n-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int ans = 1;
            for (int i = a; i <= b; i++) {
                ans *= i;
            }
            System.out.println(ans);
        }
    }
}