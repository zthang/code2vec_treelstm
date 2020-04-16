void union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u != v) {
        if (size[u] < size[v]) {
            int t = v;
            v = u;
            u = t;
        }
        p[v] = u;
        size[u] += size[v];
    }
}