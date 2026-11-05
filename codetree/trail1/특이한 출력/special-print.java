import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("(%d, %d) ", i, j);
                if ((i + j) % 4 == 0) {
                    System.out.println();
                }
            }
        }
    }
}