static int lca(int u, int v) {
    if (ok(u, v)) {
        return u;
    }
    if (ok(v, u)) {
        return v;
    }
    for (int i = l; i >= 0; i--) {
        if (!ok(f[u][i], v)) {
            u = f[u][i];
        }
    }
    return f[u][0];
}