public void dfs1(int cur, int par, int[] a, int[] dp, int[][] g) {
    dp[cur] = a[cur];
    for (int nex : g[cur]) {
        if (nex != par) {
            dfs1(nex, cur, a, dp, g);
            dp[cur] += Math.max(dp[nex], 0);
        }
    }
}