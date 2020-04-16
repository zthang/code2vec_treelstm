public static long nPr(int n, int r) {
    return fact[n] / fact[n - r];
}