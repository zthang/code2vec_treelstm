public static void dfs2(int v, int p, int l) {
    ans[v] = dp[v] + l;
    for (Integer i : con[v]) {
        if (i == p)
            continue;
        dfs2(i, v, Math.max(ans[v] - Math.max(dp[i], 0), 0));
    }
}