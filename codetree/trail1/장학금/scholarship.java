import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int midScore = sc.nextInt();
        int finScore = sc.nextInt();

        if (midScore >= 90) {
            if (finScore >= 95) {
                System.out.println(100000);
            } else if (finScore >= 90) {
                System.out.println(50000);
            } else {
                System.out.println(0);
            }
        } else {
            System.out.println(0);
        }
    }
}