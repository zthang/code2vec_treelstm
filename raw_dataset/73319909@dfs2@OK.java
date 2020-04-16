private void dfs2(int node, boolean[] vis) {
    vis[node] = true;
    for (int nn : graph[node]) {
        if (!vis[nn]) {
            int v = dp[node];
            if (dp[nn] > 0)
                v -= dp[nn];
            dp[nn] += Math.max(0, v);
            dfs2(nn, vis);
        }
    }
}