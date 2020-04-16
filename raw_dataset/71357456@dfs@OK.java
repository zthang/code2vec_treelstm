static void dfs(int u) {
    vis[u] = true;
    if (u == n - 1)
        touch[u] = true;
    for (int v : ad[u]) if (!vis[v]) {
        dfs(v);
        touch[u] |= touch[v];
    }
}