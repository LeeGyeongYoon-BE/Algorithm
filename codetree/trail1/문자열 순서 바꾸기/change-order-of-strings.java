import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        String T = sc.nextLine();
        String S = sc.nextLine();

        String temp = T;
        T = S;
        S = temp;

        System.out.println(T);
        System.out.println(S);
    }
}