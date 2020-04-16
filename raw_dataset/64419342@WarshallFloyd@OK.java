long[][] WarshallFloyd(long[][] a) {
    int n = a.length;
    long[][] ans = new long[n][n];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            ans[i][j] = a[i][j] == 0 ? (long) 1e16 : a[i][j];
            if (i == j)
                ans[i][j] = 0;
        }
    }
    for (int k = 0; k < n; k++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
            }
        }
    }
    return ans;
}