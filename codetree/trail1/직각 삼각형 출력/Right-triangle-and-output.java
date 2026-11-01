import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt = 1;

        while (n-- > 0) {
            for (int i = 0; i < cnt; i++) {
                System.out.print("*");
            }
            System.out.println();
            cnt += 2;
        }
    }
}