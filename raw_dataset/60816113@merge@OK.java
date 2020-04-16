void merge(int u, int v) {
    if (r[u] == r[v])
        ++r[u];
    if (r[u] < r[v]) {
        u ^= v;
        v ^= u;
        u ^= v;
    }
    pa[v] = u;
}