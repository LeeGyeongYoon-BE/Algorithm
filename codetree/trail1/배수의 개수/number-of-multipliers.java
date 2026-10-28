import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int i = 10;

        int cnt_3 = 0;
        int cnt_5 = 0;

        while(i-- > 0) {
            int num = sc.nextInt();
            if (num % 3 == 0) {
                cnt_3++;
            }
            if (num % 5 == 0) {
                cnt_5++;
            }
        }

        System.out.println(cnt_3 + " " + cnt_5);
    }
}