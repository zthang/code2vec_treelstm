private long[][] matCopy(long[][] a) {
    int n = a.length;
    long[][] b = new long[n][n];
    for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) b[i][j] = a[i][j];
    return b;
}