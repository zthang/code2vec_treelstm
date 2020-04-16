static boolean ok(int u, int v) {
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}