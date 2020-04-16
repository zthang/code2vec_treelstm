public static void dfs(int u) {
    vis[u] = true;
    for (int i = 0; i < graph[u].size(); i++) {
        int v = graph[u].get(i);
        if (!vis[v])
            dfs(v);
    }
}