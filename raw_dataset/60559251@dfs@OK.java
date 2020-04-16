// <>
static void dfs(int s) {
    for (int e : adj[s]) {
        if (!vis[e]) {
            vis[e] = true;
            ans--;
            dfs(e);
        }
    }
    return;
}