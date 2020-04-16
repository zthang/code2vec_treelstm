boolean union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u == v)
        return false;
    if (size[u] > size[v]) {
        int t = u;
        u = v;
        v = t;
    }
    parent[u] = v;
    size[v] += size[u];
    return true;
}