import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int cnt_2 = 0;
        int cnt_3 = 0;
        int cnt_12 = 0;

        int i = 1;

        while (i <= n) {
            if (i % 12 == 0) {
                cnt_12++;
            } else if (i % 3 == 0) {
                cnt_3++;
            } else if (i % 2 == 0) {
                cnt_2++;
            }
            i++;
        }
        System.out.println(cnt_2 + " " + cnt_3 + " " + cnt_12);
    }
}