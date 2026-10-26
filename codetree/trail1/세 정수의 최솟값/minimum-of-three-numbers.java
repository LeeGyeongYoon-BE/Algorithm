import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int min = a;
        if (min > b) {
            min = b;
        }

        if (min > c) {
            min = c;
        }

        System.out.println(min);
    }
}