static void dfs(int u) {
    vis[u] = true;
    for (int v : adjList[u]) {
        if (!vis[v]) {
            ans++;
            dfs(v);
        }
    }
}