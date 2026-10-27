import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int a = sc.nextInt();

        int i = 1;
        while (i <= N) {
            if (i % a == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            i++;
        }
    }
}