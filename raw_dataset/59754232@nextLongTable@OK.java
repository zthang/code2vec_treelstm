long[][] nextLongTable(int n, int m) throws IOException {
    long[][] a = new long[n][m];
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = in.nextLong();
    return a;
}