import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int a = 5;
        int ans = 1;
        while (a-- > 0) {
            if (sc.nextInt() % 3 != 0) {
                ans = 0;
                break;
            }
        }
        System.out.println(ans);
    }
}