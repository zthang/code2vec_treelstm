static void dfs1(int v) {
    size[v] = 1;
    for (int u : g[v]) {
        dfs1(u);
        size[v] += size[u];
    }
}