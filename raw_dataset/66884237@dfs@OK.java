static void dfs(int start) {
    vis[start] = true;
    for (Pair p : graph[start]) {
        if (vis[p.u])
            continue;
        dfs(p.u);
    }
}