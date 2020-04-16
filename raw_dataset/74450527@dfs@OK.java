static void dfs(int u, int p) {
    pa[u] = p;
    for (int v : adj[u]) {
        if (v == p)
            continue;
        L[v] = 1 + L[u];
        dfs(v, u);
    }
}