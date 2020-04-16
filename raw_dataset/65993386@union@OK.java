void union(int u, int v) {
    u = getParent(u);
    v = getParent(v);
    if (u != v) {
        numSets--;
        if (size[u] > size[v]) {
            parent[v] = u;
            size[u] += size[v];
        } else {
            parent[u] = v;
            size[v] += size[u];
        }
    }
}