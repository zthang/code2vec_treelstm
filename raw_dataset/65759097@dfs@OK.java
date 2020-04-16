private static void dfs(int v) {
    visited[v] = true;
    for (int u : graph[v]) {
        if (!visited[u]) {
            union(v, u);
            dfs(u);
        }
    }
}