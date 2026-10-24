public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        int a = 1;
        int b = 2;
        int c = 3;

        int temp = a + b + c;

        a = temp;
        b = temp;
        c = temp;

        System.out.println(a + " " + b + " " + c);
    }
}