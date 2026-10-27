import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = N; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }
}