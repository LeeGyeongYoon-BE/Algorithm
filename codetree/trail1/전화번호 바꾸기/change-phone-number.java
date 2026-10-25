import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String[] num = sc.nextLine().split("-");

        System.out.println(num[0] + "-" + num[2] + "-" + num[1]);
    }
}