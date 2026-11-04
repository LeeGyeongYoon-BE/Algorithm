import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int t = 1;

        for (int i = n; i >= 1; i--) {
            for (int j = 0; j < n - i; j++){
                System.out.print("  ");
            }
            for (int j = 0; j < i; j++){
                System.out.print(t + " ");
                t++;
                if (t == 10) {
                    t = 1;
                }
            }
            System.out.println();
        }
    }
}