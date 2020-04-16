void func(int[][] g, int[] col, int[] sub, int u, int p) {
    int x = col[u];
    for (int v : g[u]) {
        if (v != p) {
            func(g, col, sub, v, u);
            if (sub[v] > 0) {
                x += sub[v];
            }
        }
    }
    sub[u] = x;
}