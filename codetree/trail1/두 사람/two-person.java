import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] A = sc.nextLine().split(" ");
        int ageA = Integer.parseInt(A[0]);
        char genderA = A[1].charAt(0);


        String[] B = sc.nextLine().split(" ");
        int ageB = Integer.parseInt(B[0]);
        char genderB = B[1].charAt(0);

        if ((ageA >= 19 && genderA == 'M') || (ageB >= 19 && genderB == 
        'M')) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}