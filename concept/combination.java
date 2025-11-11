public static long nCr(int n, int r) {
    if (r > n - r) r = n - r; // C(n, r) = C(n, n-r)
    long result = 1;
    for (int i = 0; i < r; i++) {
        result *= (n - i);
        result /= (i + 1);
    } // for
    return result;
} // nCr
