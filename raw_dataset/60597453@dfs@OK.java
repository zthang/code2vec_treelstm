static void dfs(int i) {
    vis[i] = true;
    for (int u : adj[i]) {
        if (!vis[u])
            dfs(u);
    }
}