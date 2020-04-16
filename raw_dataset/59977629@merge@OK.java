void merge(int u, int v) {
    u = getParent(u);
    v = getParent(v);
    if (rank[u] < rank[v]) {
        u = u ^ v;
        v = u ^ v;
        u = u ^ v;
    }
    ans -= (rank[u] * (rank[u] - 1L)) / 2L;
    ans -= (rank[v] * (rank[v] - 1L)) / 2L;
    rank[u] += rank[v];
    ans += (rank[u] * (rank[u] - 1L)) / 2L;
    parr[v] = u;
}