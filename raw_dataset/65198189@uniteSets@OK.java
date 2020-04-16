void uniteSets(int v, int u) {
    v = findSet(v);
    u = findSet(u);
    if (v != u) {
        if (rank[v] > rank[u]) {
            par[u] = v;
            max[v] = Math.max(max[v], max[u]);
        } else if (rank[v] < rank[u]) {
            par[v] = u;
            max[u] = Math.max(max[v], max[u]);
        } else {
            par[u] = v;
            rank[v]++;
            max[v] = Math.max(max[v], max[u]);
        }
    }
}