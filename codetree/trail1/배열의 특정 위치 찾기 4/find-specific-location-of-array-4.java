import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int sum = 0;
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int k = sc.nextInt();
            if (k == 0) {
                break;
            } else {
                if (k % 2 == 0) {
                    sum += k;
                    cnt++;
                }
            }
        }
        System.out.println(cnt + " " + sum);
    }
}