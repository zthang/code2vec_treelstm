void dfs(int v) {
    vis[v] = 1;
    for (Node p : g[v]) {
        if (vis[p.v] == 0) {
            dfs(p.v);
        } else if (vis[p.v] == 1) {
            cycle = true;
        }
    }
    vis[v] = 2;
}