private void dfs(int x, ArrayList<Integer>[] adj, int pre) {
    if (vis[x])
        return;
    vis[x] = true;
    if (pre != -1)
        res--;
    for (int t : adj[x]) if (!vis[t])
        dfs(t, adj, x);
}