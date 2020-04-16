public static void dfs(int u) {
    tin[u] = T++;
    for (int v : adj[u]) {
        if (tin[v] == 0) {
            level[v] = level[u] + 1;
            dfs(v);
            parent[v] = u;
        }
    }
    tout[u] = T++;
}