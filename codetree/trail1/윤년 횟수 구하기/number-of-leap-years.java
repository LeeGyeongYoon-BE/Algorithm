import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int i = 1;
        int cntYear = 0;
        while (i <= N) {
            if (i % 4 == 0) {
                cntYear++;
            }
            if (i % 100 == 0 && i % 400 != 0) {
                cntYear--;
            }
            i++;
        }
        System.out.println(cntYear);
    }
}