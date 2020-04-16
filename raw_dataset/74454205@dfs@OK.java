static void dfs(int u, int p, int lvl) {
    level[u] = lvl;
    parent[u] = p;
    tin[u] = ++time;
    for (int v : g[u]) {
        if (v == p)
            continue;
        dfs(v, u, lvl + 1);
    }
    tout[u] = time;
}