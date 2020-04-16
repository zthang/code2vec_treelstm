static void func(int[][] a, int n, int k, int p) {
    for (int i = 1; i < n; i++) for (int j = 1; j <= Math.min((i + 1) * k, p); j++) for (int t2 = 0; t2 <= Math.min(k, Math.min(j, p)); t2++) {
        int aksh = 0;
        if (t2 != 0)
            aksh = a[i][t2 - 1];
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t2] + aksh);
    }
}