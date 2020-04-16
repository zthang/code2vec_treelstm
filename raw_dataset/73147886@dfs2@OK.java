static void dfs2(int s, int p) {
    ans[s] = dp[s];
    for (Integer x : graph[s]) {
        if (x == p)
            continue;
        dp[s] -= Math.max(0, dp[x]);
        dp[x] += Math.max(0, dp[s]);
        dfs2(x, s);
        dp[x] -= Math.max(0, dp[s]);
        dp[s] += Math.max(0, dp[x]);
    }
}