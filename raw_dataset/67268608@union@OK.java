public static void union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v)
        return;
    if (sz[u] > sz[v]) {
        par[v] = u;
        sz[u] += sz[v];
    } else {
        par[u] = v;
        sz[v] += sz[u];
    }
}