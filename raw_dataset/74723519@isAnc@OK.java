private static boolean isAnc(int v, int u) {
    return tin[v] <= tin[u] && tout[v] >= tout[u];
}