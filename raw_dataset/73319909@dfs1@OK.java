private void dfs1(int node, boolean[] vis) {
    vis[node] = true;
    dp[node] = color[node];
    for (int nn : graph[node]) {
        if (!vis[nn]) {
            dfs1(nn, vis);
            if (dp[nn] > 0) {
                dp[node] += dp[nn];
            }
        }
    }
}