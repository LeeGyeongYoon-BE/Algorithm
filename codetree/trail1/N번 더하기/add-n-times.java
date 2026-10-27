import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int N = sc.nextInt();

        int i = 0;
        while (i < N) {
            A += N;
            System.out.println(A);
            i++;
        }
    }
}