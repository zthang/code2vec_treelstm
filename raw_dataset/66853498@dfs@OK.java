private void dfs(int u, int a) {
    vis[u] = true;
    cnt++;
    for (int v : adj[u]) {
        if (v != a && !vis[v]) {
            dfs(v, a);
        }
    }
}