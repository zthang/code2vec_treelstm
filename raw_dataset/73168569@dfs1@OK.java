public static void dfs1(int cr, int pr) {
    dp[cr] = color[cr];
    for (int nx : adj.get(cr)) {
        if (nx == pr)
            continue;
        dfs1(nx, cr);
        dp[cr] += Math.max(dp[nx], 0);
    }
}