void dfs1(int u, int p) {
    dp_down[u] = a[u];
    for (int i = head[u]; i != 0; i = next[i]) {
        int v = to[i];
        if (v != p) {
            dfs1(v, u);
            dp_down[u] = max(dp_down[u], dp_down[u] + dp_down[v]);
        }
    }
}