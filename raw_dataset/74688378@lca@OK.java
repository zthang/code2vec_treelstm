public static int lca(int u, int v) {
    int t;
    if (d[v] > d[u]) {
        t = v;
        v = u;
        u = t;
    }
    u = walk(u, d[u] - d[v]);
    if (u == v)
        return u;
    for (int i = bl.length - 1; i >= 0; i--) {
        if (bl[i][u] != bl[i][v]) {
            u = bl[i][u];
            v = bl[i][v];
        }
    }
    return bl[0][u];
}