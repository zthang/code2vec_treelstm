void dfs(int v) {
    vis[v] = 1;
    if (v <= N)
        cc++;
    for (int u : g[v]) {
        if (vis[u] == 0)
            dfs(u);
    }
}