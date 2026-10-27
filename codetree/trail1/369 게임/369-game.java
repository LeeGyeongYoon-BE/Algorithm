import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int i = 1;
        while (i <= N) {
            if (i % 3 == 0) {
                System.out.print(0 + " ");
            } else {
                if ( (i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9 ){
                    System.out.print(0 + " ");
                } else if ( (i / 10) == 3 || (i / 10) == 6 || (i / 10) == 9 ){
                    System.out.print(0 + " ");
                } else {
                    System.out.print(i + " ");
                }
            } 

            i++;
        }
    }
}