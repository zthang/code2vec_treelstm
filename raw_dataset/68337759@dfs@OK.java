void dfs(int u, int pa) {
    for (int v : ja[u]) {
        if (v == pa)
            continue;
        dfs(v, u);
        parent[v] = u;
        d[u] = Math.max(d[v] + 1, d[u]);
    }
}