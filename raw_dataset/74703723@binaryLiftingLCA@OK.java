private static void binaryLiftingLCA(int u, int p) {
    dp[u][0] = p;
    for (int i = 1; i <= log2height; ++i) dp[u][i] = dp[dp[u][i - 1]][i - 1];
    for (int v : adjList[u]) {
        if (v != p) {
            level[v] = level[u] + 1;
            binaryLiftingLCA(v, u);
        }
    }
}