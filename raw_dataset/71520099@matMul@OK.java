private long[] matMul(long[][] a, long[] b) {
    int n = a.length;
    long[] c = new long[n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) c[i] = (c[i] + a[i][j] * b[j]) % MOD;
    }
    return c;
}