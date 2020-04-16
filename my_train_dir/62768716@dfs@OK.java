private void dfs(int u, int parent) {
    for (int v : graph.adj(u)) {
        if (v == parent) {
            continue;
        }
        color[v] = 3 - color[u] - color[parent];
        dfs(v, u);
    }
}