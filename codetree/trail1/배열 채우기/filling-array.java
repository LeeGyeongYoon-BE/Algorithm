import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] a = new int[10];

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            int k = sc.nextInt();
            if (k == 0) {
                break;
            }  else {
                a[i] = k;
                cnt++;
            }
        }

        for (int i = cnt - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
    }
}