import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int i = 2;

        String ans = "N";
        while (i < N) {
            if (N % i == 0) {
                ans = "C";
                break;
            } else {
                ans = "N";
                i++;
            }
        }
        System.out.println(ans);
    }
}