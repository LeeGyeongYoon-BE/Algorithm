import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();

        if (a == 5) {
            System.out.println("A");
        } else if (a % 2 == 0) {
            System.out.println("B");
        } 
    }
}