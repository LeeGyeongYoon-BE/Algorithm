import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        int gop = 1;

        for (int i = A; i <= B; i++) {
            gop *= i;
        }
        System.out.println(gop);
    }
}