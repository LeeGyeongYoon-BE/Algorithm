import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            int count;

            // i가 홀수이면 i + 1개
            if (i % 2 == 1) {
                count = i + 1;
            } 
            // i가 짝수이면 1개
            else {
                count = 1;
            }

            for (int j = 0; j < count; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}