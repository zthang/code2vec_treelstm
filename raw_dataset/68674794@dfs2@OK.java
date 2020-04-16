void dfs2(int v, int pr) {
    ans[v] = list.get(c[v]);
    list.remove(c[v]);
    for (int u : g[v]) {
        if (u != pr)
            dfs2(u, v);
    }
}