void uniteSets(int v, int u) {
    v = findSet(v);
    u = findSet(u);
    if (v != u) {
        if (rank[v] > rank[u]) {
            par[u] = v;
        } else if (rank[v] < rank[u]) {
            par[v] = u;
        } else {
            par[u] = v;
            rank[v]++;
        }
    }
}