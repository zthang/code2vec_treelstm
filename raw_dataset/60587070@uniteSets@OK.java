void uniteSets(int v, int u) {
    v = findSet(v);
    u = findSet(u);
    if (v != u) {
        if (rank[v] < rank[u]) {
            v ^= u;
            u ^= v;
            v ^= u;
        }
        par[u] = v;
        if (rank[v] == rank[u])
            rank[v]++;
    }
}