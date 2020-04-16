private int dfs(int u) {
    seen[u] = true;
    int max = u;
    for (int v : g[u]) if (!seen[v]) {
        max = Math.max(max, dfs(v));
    }
    return max;
}