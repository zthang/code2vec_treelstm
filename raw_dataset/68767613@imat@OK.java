int[][] imat(int n, int m) throws IOException {
    int[][] mat = new int[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) mat[i][j] = ni();
    }
    return mat;
}