int[] bfs(int src) {
    int[] dp = new int[n];
    int l = 0, r = 0;
    int[] q = new int[n << 1];
    boolean[] vis = new boolean[n];
    vis[src] = true;
    q[r++] = src;
    q[r++] = 0;
    while (l != r) {
        int node = q[l++];
        int d = q[l++];
        dp[node] = d;
        for (int i : adj[node]) if (!vis[i]) {
            vis[i] = true;
            q[r++] = i;
            q[r++] = d + 1;
        }
    }
    return dp;
}