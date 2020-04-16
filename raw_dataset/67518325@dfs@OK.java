static void dfs(int u) {
    visited[u] = true;
    for (int v : adj[u]) if (!visited[v])
        dfs(v);
}