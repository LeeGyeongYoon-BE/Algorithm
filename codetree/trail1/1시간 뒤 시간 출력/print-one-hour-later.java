import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String t = sc.nextLine();

        String[] time = t.split(":");

        System.out.println((Integer.parseInt(time[0]) + 1) + ":" + time[1]);
    }
}