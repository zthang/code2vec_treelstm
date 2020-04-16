static void dfs(int v, int p) {
    dp[v] = d[v] + 1;
    for (int e : adj[v]) {
        if (e == p) {
            continue;
        }
        dfs(e, v);
        ans = Math.max(ans, dp[e] + dp[v] - 2);
        dp[v] = Math.max(dp[v], dp[e] + d[v] - 1);
    }
}