public static void dfs(int u, int p) {
    visited[u] = true;
    max = Math.max(max, u);
    for (int v : list[u]) {
        if (!visited[v] && v != p) {
            dfs(v, u);
        }
    }
}