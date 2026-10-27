import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int i = A > B ? A : B;

        while (i >= (A > B ? B : A)) {
            System.out.print(i + " ");
            i--;
        }
    }
}