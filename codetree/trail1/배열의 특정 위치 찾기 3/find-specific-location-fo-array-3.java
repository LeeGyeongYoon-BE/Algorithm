import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[100];
        int target = 0;
        for (int i = 0; i < 100; i++) {
            int a = sc.nextInt();
            if (a == 0) {
                target = i;
                break;
            } else {
                arr[i] = a;
            }
        }

        int sum = 0;
        for (int i = target - 3; i < target; i++) {
            sum += arr[i];
        }
        System.out.println(sum);

    }
}