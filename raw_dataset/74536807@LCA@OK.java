static int LCA(int u, int v) {
    if (lvl[u] < lvl[v]) {
        int tmp = u;
        u = v;
        v = tmp;
    }
    for (int i = log - 1; i >= 0; i--) {
        if (lvl[u] - (1 << i) >= lvl[v])
            u = up[u][i];
    }
    if (u == v)
        return u;
    for (int i = log - 1; i >= 0; i--) {
        if (up[u][i] != -1 && (up[u][i] != up[v][i])) {
            u = up[u][i];
            v = up[v][i];
        }
    }
    return up[u][0];
}