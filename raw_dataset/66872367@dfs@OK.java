void dfs(int u, int fa, int a, int b) {
    ct++;
    vis[u] = true;
    int sz = g[u].size();
    for (int i = 0; i < sz; i++) {
        int v = g[u].get(i);
        if (v == fa)
            continue;
        if (vis[v])
            continue;
        if (v == a) {
            hasV = true;
            continue;
        }
        if (v == b) {
            hasU = true;
            continue;
        }
        dfs(v, u, a, b);
    }
}