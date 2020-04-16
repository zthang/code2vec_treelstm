static void dfs(int u, int p) {
    tin[u] = time++;
    f[u][0] = p;
    for (int i = 1; i <= l; i++) {
        f[u][i] = f[f[u][i - 1]][i - 1];
    }
    for (int v : adj[u]) {
        if (v != p) {
            d[v] = d[u] + 1;
            dfs(v, u);
        }
    }
    tout[u] = time++;
}