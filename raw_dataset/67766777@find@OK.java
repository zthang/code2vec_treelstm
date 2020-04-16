int find(int u) {
    if (p[u] != u) {
        int p0 = find(p[u]);
        p[u] = p0;
    }
    return p[u];
}