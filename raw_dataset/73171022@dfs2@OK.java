void dfs2(int u, int p) {
    for (int i = head[u]; i != 0; i = next[i]) {
        int v = to[i];
        if (v != p) {
            dp_up[v] = max(dp_up[u], 0) + dp_down[u] - max(0, dp_down[v]);
            dfs2(v, u);
        }
    }
}