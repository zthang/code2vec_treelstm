void dfs(int u, int pa) {
    low[u] = visit[u] = ++T;
    boolean a = true;
    for (pair e : al[u]) {
        int v = e.F;
        if (v == pa)
            continue;
        if (visit[v] != 0) {
            low[u] = Math.min(low[u], visit[v]);
        } else {
            dfs(v, u);
            low[u] = Math.min(low[u], low[v]);
        }
        if (low[v] > visit[u]) {
            b[e.S] = true;
        }
    }
}