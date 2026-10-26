import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        double h = sc.nextDouble();
        double w = sc.nextDouble();

        int b = (int) ((w * 10000) / (h * h));

        System.out.println(b);
        if (b >= 25) {
            System.out.println("Obesity");
        }
    }
}