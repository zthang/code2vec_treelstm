public void merge(int u, int v) {
    int dadU = dad(u);
    int dadV = dad(v);
    if (dadU == dadV)
        return;
    if (u != v) {
        if (rank[u] < rank[v]) {
            parent[u] = v;
            rank[v] += rank[u];
        } else if (rank[u] == rank[v]) {
            parent[u] = v;
            rank[v] += rank[u];
        } else {
            parent[v] = u;
            rank[u] += rank[v];
        }
    }
}