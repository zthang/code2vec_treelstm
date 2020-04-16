public void dfs(int node, int parent) {
    for (int i = 0; i < 6; i++) dp[node][i] = c[node][i / 2];
    for (int i : G[node]) {
        if (i == parent)
            continue;
        dfs(i, node);
        for (int j = 0; j < 6; j++) dp[node][j] += dp[i][map[j]];
    }
}