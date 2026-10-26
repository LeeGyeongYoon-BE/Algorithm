import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();

        if (score == 100) {
            System.out.println("pass");
        } else {
            System.out.println("failure");
        }
    }
}