public long[][] buildrui(int[][] a) {
    int n = a.length;
    int m = a[0].length;
    long[][] ans = new long[n][m];
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            ans[i][j] = a[i][j];
        }
    }
    for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
            ans[i][j] += ans[i][j - 1] + ans[i - 1][j] - ans[i - 1][j - 1];
        }
    }
    return ans;
}