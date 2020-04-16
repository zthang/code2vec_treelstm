static void dfs(int u, int p) {
    tin[u] = time++;
    bap[u] = p;
    for (int v : adj[u]) {
        if (v != p) {
            d[v] = d[u] + 1;
            dfs(v, u);
        }
    }
    tout[u] = time++;
}