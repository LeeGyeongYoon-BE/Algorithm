import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int n = 3;

        int[] arr = new int[4]; // 0 : A, 1 : B, 2 : C, 3 : D
        while (n-- > 0) {
            String[] a = sc.nextLine().split(" ");

            if (a[0].equals("Y")) {
                if (Integer.parseInt(a[1]) >= 37) {
                    arr[0]++;
                } else {
                    arr[2]++;
                }
            } else {
                if (Integer.parseInt(a[1]) >= 37) {
                    arr[1]++;
                } else {
                    arr[3]++;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            System.out.print(arr[i] + " ");
        }

        if (arr[0] >= 2) {
            System.out.print("E");
        }
    }
}