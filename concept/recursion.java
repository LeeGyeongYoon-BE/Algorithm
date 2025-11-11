// 숫자 출력
class PrintNumber {
    public void asc(int n) {
        if (n == 0) return;
        asc(n - 1);
        System.out.printf("%d", n);
    } // asc
    public void desc(int n) {
        if (n == 0) return;
        System.out.printf("%d", n);
        desc(n - 1);
    } // desc
} // class
