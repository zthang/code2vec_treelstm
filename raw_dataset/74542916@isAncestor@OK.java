private static boolean isAncestor(int u, int v) {
    return tin[u] <= tin[v] && tout[v] <= tout[u];
}