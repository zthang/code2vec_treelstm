public int __query(int u, int v) {
    if (height[u] > height[v]) {
        int diff = height[u] - height[v];
        u = getParent(u, diff);
    } else if (height[v] > height[u]) {
        int diff = height[v] - height[u];
        v = getParent(v, diff);
    }
    if (u == v) {
        return u;
    }
    for (int x = log - 1; x >= 0; x--) {
        if (lca[u][x] != lca[v][x]) {
            u = lca[u][x];
            v = lca[v][x];
        }
    }
    return lca[u][0];
}