private static int findLCA(int u, int v) {
    if (level[u] < level[v]) {
        u ^= v;
        v ^= u;
        u ^= v;
    }
    for (int i = log2height; i >= 0; --i) {
        if (level[u] - Math.pow(2, i) >= level[v])
            u = dp[u][i];
    }
    if (u == v)
        return u;
    for (int i = log2height; i >= 0; --i) {
        if (dp[u][i] != dp[v][i]) {
            u = dp[u][i];
            v = dp[v][i];
        }
    }
    return dp[u][0];
}