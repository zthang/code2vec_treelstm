static void dfs(int start, int par) {
    dp[start] = col[start];
    for (int u : graph[start]) {
        if (u == par)
            continue;
        dfs(u, start);
        dp[start] += Math.max(dp[u], 0);
    // if(start==2)debug(dp[start],u,dp[u]);
    }
}