import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);


        int i = 0;
        while (i < 3) {
            int a = sc.nextInt();

            if (a % 2 != 0) {
                continue;
            } else {
                System.out.println(a / 2);
                i++;
            }
        }
    }
}