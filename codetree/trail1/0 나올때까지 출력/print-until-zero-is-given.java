import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();

            if (a == 0) {
                break;
            } else {
                System.out.println(a);
            }
        }
    }
}