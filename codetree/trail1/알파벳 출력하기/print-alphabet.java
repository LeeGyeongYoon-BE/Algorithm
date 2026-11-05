import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = 65;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (k == 91) {
                    k = 65;
                }
                System.out.print((char) k);
                k++;
            }
            System.out.println();
        }
    }
}