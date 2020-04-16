public int[][] intarr(int n, int m) {
    int[][] arr = new int[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            arr[i][j] = ni();
        }
    }
    return arr;
}