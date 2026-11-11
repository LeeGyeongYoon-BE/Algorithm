import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int[] dice = new int[7];

        for (int i = 0; i < 10; i++) {
            dice[sc.nextInt()]++;
        }

        for (int i = 1; i < 7; i++) {
            System.out.println(i + " - " + dice[i]);
        }
    }
}