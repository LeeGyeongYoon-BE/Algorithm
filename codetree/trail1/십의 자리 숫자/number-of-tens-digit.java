import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        while (true) {
            int a = sc.nextInt();
            if (a == 0) {
                break;
            } else {
                arr[a / 10]++;
            }
        }

        for (int i = 1; i < 10; i++) {
            System.out.println(i + " - " + arr[i]);
        }
    }
}