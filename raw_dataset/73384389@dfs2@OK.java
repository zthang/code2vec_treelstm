static void dfs2(int start, int par, int p) {
    dp[start] += Math.max(0, p);
    ans[start] = dp[start];
    for (int u : graph[start]) {
        if (u == par)
            continue;
        int d = dp[start];
        if (dp[u] > 0)
            d -= dp[u];
        dfs2(u, start, d);
    }
}