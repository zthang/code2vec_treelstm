static long ncr(long n, int k) {
    long m = (long) 1e9 + 7;
    long[] C = new long[k + 1];
    // nC0 is 1
    C[0] = 1;
    for (int i = 1; i <= n; i++) {
        // triangle using the previous row
        for (int j = Math.min(i, k); j > 0; j--) C[j] = (C[j] % m + C[j - 1] % m) % m;
    }
    return C[k] % m;
}