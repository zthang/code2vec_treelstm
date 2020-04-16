static void dfs(int v) {
    vis[v] = 1;
    for (int u : g[v]) {
        if (vis[u] == 0)
            dfs(u);
        else if (vis[u] == 1)
            cycle = true;
    }
    vis[v] = 2;
}