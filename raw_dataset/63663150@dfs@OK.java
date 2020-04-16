static void dfs(int x) {
    ++szcc;
    vis[x] = true;
    for (int e : adj[x]) {
        if (!vis[e]) {
            dfs(e);
        }
    }
}