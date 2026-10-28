import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int i = 5;
        while (i-- > 0) {
            int num = sc.nextInt();

            if (num % 2 == 0) {
                cnt++;        
            }
        }
        System.out.println(cnt);
    }
}