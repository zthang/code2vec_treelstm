static void dfs(int v) {
    for (int u : g[v]) {
        if (set[u] == 0) {
            set[u] = set[v] ^ 1;
            dfs(u);
        } else if (set[u] == set[v]) {
            can = false;
        }
    }
}