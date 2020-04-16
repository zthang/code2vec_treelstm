public static boolean isAncestor(int u, int v) {
    return tin[u] <= tin[v] && tout[u] >= tout[v];
}