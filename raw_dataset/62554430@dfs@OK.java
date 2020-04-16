static long dfs(int i, int p, int c1, int c2, int d) {
    dist = Math.max(dist, d);
    if (dp[i][c1][c2] == Long.MAX_VALUE) {
        for (int k = 1; k <= 3; k++) {
            if (k != c1 && k != c2) {
                long v = cost[k][i];
                for (int j : gph[i]) {
                    if (j != p) {
                        v += dfs(j, i, c2, k, d + 1);
                    }
                }
                dp[i][c1][c2] = Math.min(dp[i][c1][c2], v);
            }
        }
    }
    return dp[i][c1][c2];
}