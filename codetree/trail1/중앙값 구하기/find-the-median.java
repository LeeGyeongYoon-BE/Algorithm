import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if (a > b) {
            if (c > a) {
                System.out.println(a);
            } else {
                System.out.println(b > c ? b : c);
            }
        } else {
            if (c > b) {
                System.out.println(b);
            } else {
                System.out.println(a > c ? a : c);
            }
        }
    }
}