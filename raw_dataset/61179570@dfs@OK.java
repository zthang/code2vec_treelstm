static void dfs(int u) {
    vis[u] = true;
    for (int v : adjList[u]) {
        if (!taken[deg[u]][deg[v]]) {
            taken[deg[u]][deg[v]] = true;
            taken[deg[v]][deg[u]] = true;
            cand++;
        }
        if (!vis[v])
            dfs(v);
    }
}