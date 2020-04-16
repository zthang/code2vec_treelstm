void f(int[][] g, int[] col, int[] sub, int[] ans, int u, int p, int val) {
    val += col[u];
    for (int v : g[u]) {
        if (v != p && sub[v] > 0) {
            val += sub[v];
        }
    }
    ans[u] = val;
    for (int v : g[u]) {
        if (v != p) {
            f(g, col, sub, ans, v, u, Math.max(0, ans[u] - Math.max(sub[v], 0)));
        }
    }
}