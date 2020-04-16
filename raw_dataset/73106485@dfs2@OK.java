public static void dfs2(int v, int p) {
    ans[v] = dp[v];
    for (Integer i : con[v]) {
        if (i == p)
            continue;
        dp[v] -= Math.max(dp[i], 0);
        dp[i] += Math.max(dp[v], 0);
        dfs2(i, v);
        dp[i] -= Math.max(dp[v], 0);
        dp[v] += Math.max(dp[i], 0);
    }
}