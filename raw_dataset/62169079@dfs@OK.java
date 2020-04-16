static void dfs(int u, int p) {
    // dp[0][u]without connecting to a parent
    dp[0][u] = dp[1][u] = 1;
    for (int v : adj[u]) {
        if (v != p) {
            dfs(v, u);
        }
    }
    int max1 = 0, max2 = 0;
    for (int v : adj[u]) {
        if (v != p) {
            if (dp[1][v] > max2) {
                max2 = dp[1][v];
            }
            if (max1 < max2) {
                int tmp = max2;
                max2 = max1;
                max1 = tmp;
            }
        }
    }
    if (max2 > 1) {
        dp[0][u] += max1 + max2 + adj[u].size() - 2;
        dp[1][u] += max1 + adj[u].size() - 1;
        if (p != -1)
            dp[1][u]--;
    } else if (max1 > 1) {
        dp[0][u] += max1 + adj[u].size() - 1;
        dp[1][u] += max1 + adj[u].size() - 1;
        if (p != -1)
            dp[1][u]--;
    } else {
        dp[0][u] += adj[u].size();
        dp[1][u] += adj[u].size();
        if (p != -1)
            dp[1][u]--;
    }
}