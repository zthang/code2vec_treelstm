public long[][] multiply(long[][] a, long[][] b) {
    long[][] ans = new long[a.length][b[0].length];
    for (int i = 0; i < ans.length; i++) {
        for (int j = 0; j < ans[0].length; j++) {
            for (int k = 0; k < b.length; k++) {
                ans[i][j] += a[i][k] * b[k][j];
                ans[i][j] %= mod;
            }
        }
    }
    return ans;
}