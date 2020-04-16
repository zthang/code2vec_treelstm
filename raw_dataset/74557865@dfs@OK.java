void dfs(int u, int p, int k) {
    lev[u] = k;
    time++;
    pre[u] = time;
    par[u] = p;
    for (int v : g[u]) {
        if (v != p)
            dfs(v, u, k + 1);
    }
    time++;
    post[u] = time;
}