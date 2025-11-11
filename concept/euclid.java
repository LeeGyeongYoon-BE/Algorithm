// 두 정수 a, b가 있을 때 (a > b)
// gcd(a, b) = gcd(b, a % b)이고
// b가 0이 될 때의 a가 최대공약수

public static int gcd(int a, int b) {
        if (b == 0) return a; // b가 0이면 a가 최대공약수
        return gcd(b, a % b); // 나머지 연산을 반복
} // gcd

public static int lcm(int a, int b) {
    return a * b / gcd(a, b); // 최소공배수
} // lcm
