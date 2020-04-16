void dfs(int[][] g, int[] val, int[] a, int u, int p) {
    val[u] = a[u];
    for (int v : g[u]) {
        if (v == p)
            continue;
        dfs(g, val, a, v, u);
        val[u] += Math.max(val[v], 0);
    }
}