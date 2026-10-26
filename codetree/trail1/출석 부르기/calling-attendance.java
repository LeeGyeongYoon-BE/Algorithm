import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        switch (num) {
            case 1:
                System.out.println("John");
                break;
            case 2:
                System.out.println("Tom");
                break;
            case 3:
                System.out.println("Paul");
                break;
            default:
                System.out.println("Vacancy");
                break;
        }
    }
}