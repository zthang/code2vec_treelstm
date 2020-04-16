static void dfs2(ArrayList<Integer>[] gr, int p, int pa) {
    ans[p] = dp[p];
    if (pa != -1) {
        if (dp[p] > 0) {
            ans[p] += Math.max(ans[pa] - dp[p], 0);
        } else {
            ans[p] += Math.max(ans[pa], 0);
        }
    }
    for (Integer ch : gr[p]) {
        if (ch != pa)
            dfs2(gr, ch, p);
    }
}