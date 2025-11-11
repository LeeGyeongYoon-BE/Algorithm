// 함수가 자기 자신을 호출하는 프로그래밍 기법
// 문제를 더 작은 동일 문제로 분할하여 해결
// 종료 조건을 반드시 포함해야 함

// 팩토리얼
public class Factorial {
    static int factorial(int n) {
        if (n == 0) return 1; // Base Case
        return n * factorial(n - 1); // 재귀 호출
    } // factorial

    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    } // main
} // class

// 피보나치 수열
public class Fibonacci {
    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1; // Base Case
        return fib(n - 1) + fib(n - 2); // 재귀 호출
    } // fib

    public static void main(String[] args) {
        System.out.println(fib(7)); // 13
    } // main
} // class

// 배열 합 구하기
public class ArraySum {
    static int sum(int[] arr, int index) {
        if (index == arr.length) return 0; // Base Case
        return arr[index] + sum(arr, index + 1); // 재귀 호출
    } // sum

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(sum(arr, 0)); // 15
    } // main
} // class
