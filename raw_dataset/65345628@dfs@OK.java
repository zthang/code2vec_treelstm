static void dfs(int v) {
    if (vis[v])
        return;
    vis[v] = true;
    l = Math.min(l, v);
    r = Math.max(r, v);
    for (int u : adj[v]) {
        dfs(u);
    }
}