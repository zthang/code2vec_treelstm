static void dfs(int i, int par, int val) {
    ans[i] = cnt[i] + val;
    for (int u : adj[i]) {
        if (u != par) {
            dfs(u, i, Math.max(ans[i] - Math.max(cnt[u], 0), 0));
        }
    }
}