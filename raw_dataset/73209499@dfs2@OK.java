public void dfs2(int cur, int par, int[] dp, int[] ans, int[][] g, int parV) {
    ans[cur] = dp[cur] + parV;
    for (int nex : g[cur]) {
        if (nex != par) {
            dfs2(nex, cur, dp, ans, g, Math.max(ans[cur] - Math.max(dp[nex], 0), 0));
        }
    }
}