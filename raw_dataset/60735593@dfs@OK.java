static void dfs(int v) {
    se++;
    vis[v] = true;
    for (int d : ad[v]) if (!vis[d])
        dfs(d);
}