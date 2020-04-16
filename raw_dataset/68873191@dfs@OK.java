static void dfs(int u) {
    vis[u] = true;
    for (int v : adj[u]) {
        if (!vis[v]) {
            count++;
            dfs(v);
        }
    }
}