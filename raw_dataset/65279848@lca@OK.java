static int lca(int u, int v) {
    if (depth[v] < depth[u])
        u = walk(u, depth[u] - depth[v]);
    if (depth[u] < depth[v])
        v = walk(v, depth[v] - depth[u]);
    if (u == v)
        return u;
    for (int k = blsz; k >= 0; k--) if (bl[k][u] != bl[k][v]) {
        u = bl[k][u];
        v = bl[k][v];
    }
    return bl[0][v];
}