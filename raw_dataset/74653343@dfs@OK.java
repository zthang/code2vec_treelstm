static void dfs(int u) {
    vis[u] = true;
    in[u] = globalTime++;
    for (int v : adj[u]) if (!vis[v]) {
        level[v] = level[u] + 1;
        parent[v] = u;
        dfs(v);
    }
    out[u] = globalTime++;
}