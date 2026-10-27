import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] A = sc.nextLine().split(" ");

        char coldA = A[0].charAt(0);
        int tempA = Integer.parseInt(A[1]);

        String[] B = sc.nextLine().split(" ");

        char coldB = B[0].charAt(0);
        int tempB = Integer.parseInt(B[1]);

        String[] C = sc.nextLine().split(" ");

        char coldC = C[0].charAt(0);
        int tempC = Integer.parseInt(C[1]);

        int countA = 0;

        if (coldA == 'Y' && tempA >= 37) {
            countA++;
        }

        if (coldB == 'Y' && tempB >= 37) {
            countA++;
        }

        if (coldC == 'Y' && tempC >= 37) {
            countA++;
        }

        if (countA >= 2) {
            System.out.println("E");
        } else {
            System.out.println("N");
        }
    }
}