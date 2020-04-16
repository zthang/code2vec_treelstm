static int lca(int u, int v) {
    if (D[u] < D[v]) {
        int t = u;
        u = v;
        v = t;
    }
    int diff = D[u] - D[v];
    for (int i = 0; i < ln; i++) {
        if ((diff & (1 << i)) != 0) {
            u = L[u][i];
        }
    }
    if (u == v)
        return u;
    for (int i = ln - 1; i >= 0; i--) {
        if (L[u][i] != L[v][i]) {
            u = L[u][i];
            v = L[v][i];
        }
    }
    return L[u][0];
}