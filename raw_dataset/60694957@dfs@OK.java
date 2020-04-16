void dfs(int v) {
    vis[v] = true;
    sz++;
    for (int u : graph[v]) {
        if (!vis[u])
            dfs(u);
    }
}