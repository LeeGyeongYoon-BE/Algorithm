import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int N = sc.nextInt();

        while (N-- > 0) {
            int a = sc.nextInt();
            if (a % 2 != 0 && a % 3 == 0) {
                sum += a;
            }
        }
        System.out.println(sum);
    }
}