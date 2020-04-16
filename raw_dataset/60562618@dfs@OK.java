private int dfs(int node, boolean[] vis, int[][] adj) {
    vis[node] = true;
    int ans = 1;
    for (int n : adj[node]) {
        if (vis[n])
            continue;
        ans += dfs(n, vis, adj);
    }
    return ans;
}