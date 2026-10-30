import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        while (true) {
            String[] a = sc.nextLine().split(" ");

            if (a[2].equals("C")) {
                System.out.println(Integer.parseInt(a[0]) * Integer.parseInt(a[1]));
                break;
            } else {
                System.out.println(Integer.parseInt(a[0]) * Integer.parseInt(a[1]));
            }
        }
    }
}