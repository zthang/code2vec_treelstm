static void union(int u, int v) {
    u = find(u);
    v = find(v);
    if (u > v) {
        parent[v] = u;
    } else if (v > u) {
        parent[u] = v;
    }
}