private long[][] matIdentity(int n) {
    long[][] a = new long[n][n];
    for (int i = 0; i < n; i++) a[i][i] = 1;
    return a;
}