import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int i = 1;

        while (i <= N) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
            i++;
        }
    }
}