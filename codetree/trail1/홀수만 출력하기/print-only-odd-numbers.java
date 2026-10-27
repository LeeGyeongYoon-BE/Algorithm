import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        while (N-- > 0) {
            int i = sc.nextInt();
            if (i % 3 == 0 && i % 2 != 0) {
                System.out.println(i);
            }
        }
    }
}