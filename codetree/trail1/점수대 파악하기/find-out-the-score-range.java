import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[11];

        while (true) {
            int a = sc.nextInt();
            if (a == 0) {
                break;
            } else {
                arr[a / 10]++;
            }
        }

        for (int i = 10; i >= 1; i--) {
            System.out.println(i * 10 + " - " + arr[i]);
        }
    }
}