int dfs(int u) {
    vis[u] = true;
    int ans = 1;
    for (int v : graph[u]) {
        if (!vis[v]) {
            ans += dfs(v);
        }
    }
    return ans;
}