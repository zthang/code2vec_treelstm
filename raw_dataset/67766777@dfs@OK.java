private void dfs(int u, int p) {
    if (visited[u])
        return;
    visited[u] = true;
    for (int v : g[u]) {
        if (v != p) {
            dfs(v, u);
        }
    }
}