boolean unite(int u, int v, int[] dsu, int[] rank) {
    v = get(v, dsu);
    u = get(u, dsu);
    if (v == u) {
        return false;
    }
    if (rank[u] == rank[v]) {
        if (((u ^ v) & 1) == 0) {
            ++rank[u];
        } else {
            ++rank[v];
        }
    }
    if (rank[u] < rank[v]) {
        dsu[u] = v;
    } else {
        dsu[v] = u;
    }
    return true;
}