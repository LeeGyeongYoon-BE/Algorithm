import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();

            if (a < 25) {
                System.out.println("Higher");
            } else if (a > 25) {
                System.out.println("Lower");
            } else {
                System.out.println("Good");
                break;
            }
        }
    }
}