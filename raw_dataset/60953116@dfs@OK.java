private void dfs(int v, int p) {
    if (!inCore[v]) {
        return;
    }
    inCore[v] = false;
    for (int u : adj[v]) {
        if (u != p && parent[u] != v) {
            --deg[u];
            parent[v] = u;
            if (deg[u] <= 1) {
                dfs(u, v);
            }
        }
    }
}