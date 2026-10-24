public class Main {
    public static void main(String[] args) {
        // Please write your code here.
        int a = 3;
        int b = 5;
        int cnt = b;
        b = a;
        a = cnt;

        System.out.println(a);
        System.out.println(b);
    }
}