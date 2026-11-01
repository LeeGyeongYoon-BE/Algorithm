import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String ans = "P";
        for (int i = 2; i < N; i++) {
            if (N % i == 0) {
                ans = "C";
                break;
            }
        }
        System.out.println(ans);

    }
}