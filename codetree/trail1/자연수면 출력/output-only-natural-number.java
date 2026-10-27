import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        if (A <= 0) {
            System.out.println(0);
        } else {
            while (B-- > 0) {
                System.out.print(A);
            }
        }
    }
}