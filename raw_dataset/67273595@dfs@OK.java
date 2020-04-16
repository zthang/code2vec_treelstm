void dfs(int x) {
    vis[x] = 1;
    for (int y : adj[x]) if (vis[y] == 0)
        dfs(y);
}