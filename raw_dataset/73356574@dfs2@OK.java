void dfs2(int[][] g, int[] ans, int[] val, int u, int p) {
    ans[u] = val[u];
    for (int v : g[u]) {
        if (v == p)
            continue;
        val[u] -= Math.max(val[v], 0);
        val[v] += Math.max(val[u], 0);
        dfs2(g, ans, val, v, u);
        val[v] -= Math.max(val[u], 0);
        val[u] += Math.max(val[v], 0);
    }
}