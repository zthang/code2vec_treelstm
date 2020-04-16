public static long nCr(int n, int r) {
    return (fact[n] / fact[r]) / fact[n - r];
}