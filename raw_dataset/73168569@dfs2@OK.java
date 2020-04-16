public static void dfs2(int cr, int pr) {
    ans[cr] = dp[cr];
    for (int nx : adj.get(cr)) {
        if (nx == pr)
            continue;
        dp[cr] -= Math.max(dp[nx], 0);
        dp[nx] += Math.max(dp[cr], 0);
        dfs2(nx, cr);
        dp[nx] -= Math.max(dp[cr], 0);
        dp[cr] += Math.max(dp[nx], 0);
    }
}