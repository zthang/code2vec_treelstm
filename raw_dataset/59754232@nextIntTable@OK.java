int[][] nextIntTable(int n, int m) throws IOException {
    int[][] a = new int[n][m];
    for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) a[i][j] = in.nextInt();
    return a;
}