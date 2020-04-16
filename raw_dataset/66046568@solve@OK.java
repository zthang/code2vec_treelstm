public void solve() throws QuickAnswer {
    int[][] dp = new int[n + 1][n + 1];
    applyGraph(dp);
    applyGraph(dp);
    int[] max = new int[n];
    max[0] = dp[0][1];
    for (int i = 1; i < n; i++) {
        int m = dp[0][i + 1];
        for (int j = 0; j < i; j++) {
            m = Math.max(m, max[j] + dp[j + 1][i + 1]);
        }
        max[i] = m;
    }
    print(max[n - 1]);
}