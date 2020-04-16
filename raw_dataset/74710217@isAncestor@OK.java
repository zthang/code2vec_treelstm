static boolean isAncestor(int u, int v) {
    // is u ancestor of v
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}