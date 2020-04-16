void dfs(int cur, int par) {
    dp[cur] = color[cur];
    for (int i : a[cur]) if (i != par) {
        dfs(i, cur);
        dp[cur] = Math.max(dp[i] + dp[cur], dp[cur]);
    }
}