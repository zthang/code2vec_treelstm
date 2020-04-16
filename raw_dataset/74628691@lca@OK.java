public int lca(int u, int v) {
    if (u > G.length || v > G.length)
        throw new RuntimeException("Node out or range in LCA");
    if (depth[v] < depth[u])
        u = u + v - (v = u);
    int difference = depth[v] - depth[u];
    for (int i = 0; i < levels; i++) if (((difference >> i) & 1) != 0)
        v = parent[v][i];
    if (u == v)
        return u;
    for (int i = levels - 1; i >= 0; i--) {
        if (parent[u][i] != parent[v][i]) {
            u = parent[u][i];
            v = parent[v][i];
        }
    }
    if (parent[u][0] != parent[v][0])
        throw new RuntimeException("How possible");
    return parent[u][0];
}