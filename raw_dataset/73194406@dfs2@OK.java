void dfs2(int cur, int par) {
    int t = dp[par], t1 = dp[cur];
    dp[par] -= Math.max(0, dp[cur]);
    dp[cur] = Math.max(dp[cur] + dp[par], dp[cur]);
    ans[cur] = dp[cur];
    for (int i : a[cur]) if (i != par)
        dfs2(i, cur);
    dp[par] = t;
    dp[cur] = t1;
}