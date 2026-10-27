import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().split(" ");

        if (s[0].charAt(0) == 'A') {
            int i = 1;
            while (i <= Integer.parseInt(s[1])) {
                System.out.print(i + " ");
                i++;
            }
        } else {
            int i = Integer.parseInt(s[1]);
            while (i >= 1) {
                System.out.print(i + " ");
                i--;
            }
        }
    }
}