long nCr(int n, int k) {
    long[] C = new long[k + 1];
    // nC0 is 1
    C[0] = 1;
    for (int i = 1; i <= n; i++) {
        for (int j = Math.min(i, k); j > 0; j--) {
            C[j] = C[j] + C[j - 1];
        }
    }
    return C[k];
}