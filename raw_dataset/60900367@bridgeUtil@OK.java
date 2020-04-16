void bridgeUtil(int[][][] g, boolean[] ans, boolean[] vis, int[] disc, int[] low, int u, int p, int t) {
    vis[u] = true;
    disc[u] = low[u] = ++t;
    for (int[] v : g[u]) {
        if (!vis[v[0]]) {
            bridgeUtil(g, ans, vis, disc, low, v[0], u, t);
            low[u] = Math.min(low[u], low[v[0]]);
            if (low[v[0]] > disc[u])
                ans[v[1]] = true;
        } else if (p != v[0])
            low[u] = Math.min(low[u], disc[v[0]]);
    }
}