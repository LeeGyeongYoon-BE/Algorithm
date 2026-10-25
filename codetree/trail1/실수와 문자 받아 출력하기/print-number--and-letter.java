import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        char c = sc.nextLine().charAt(0);
        double a = sc.nextDouble();
        double b = sc.nextDouble();

        System.out.println(c);
        System.out.printf("%.2f\n", a);
        System.out.printf("%.2f", b);
    }
}