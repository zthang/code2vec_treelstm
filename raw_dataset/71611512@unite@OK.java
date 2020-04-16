void unite(int v, int u) {
    v = find(v);
    u = find(u);
    if (v == u)
        return;
    if (size[v] < size[u]) {
        v ^= u;
        u ^= v;
        v ^= u;
    }
    p[u] = v;
    size[v] += size[u];
}