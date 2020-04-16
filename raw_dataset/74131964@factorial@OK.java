private static long[] factorial(int n, long mod) {
    long[] factor = new long[n + 1];
    factor[0] = 1;
    for (int i = 1; i <= n; i++) {
        factor[i] = factor[i - 1] * i % mod;
    }
    return factor;
}