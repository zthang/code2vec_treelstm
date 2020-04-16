public void addEdge(int v, int u) {
    v = root(v);
    u = root(u);
    parent[u] = v;
    rank[v] += rank[u];
}