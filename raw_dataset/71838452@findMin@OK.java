long findMin(boolean[] part, long[][] adj, int k) {
    long[][] dp = new long[k + 1][part.length];
    for (int i = 0; i <= k; i++) {
        Arrays.fill(dp[i], INF);
    }
    dp[0][0] = 0;
    for (int i = 1; i <= k; i++) {
        for (int to = 0; to < part.length; to++) {
            for (int from = 0; from < part.length; from++) {
                if (part[from] != part[to]) {
                    dp[i][to] = Math.min(dp[i][to], dp[i - 1][from] + adj[from][to]);
                }
            }
        }
    }
    return dp[k][0];
}