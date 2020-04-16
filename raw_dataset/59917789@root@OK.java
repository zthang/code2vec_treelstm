private int root(int v) {
    while (v != parent[v]) {
        parent[v] = parent[parent[v]];
        v = parent[v];
    }
    return v;
}