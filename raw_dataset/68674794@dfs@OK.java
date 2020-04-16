int dfs(int v, int pr) {
    int cc = 0;
    for (int u : g[v]) {
        if (u != pr)
            cc += dfs(u, v);
    }
    if (cc < c[v])
        check = false;
    return cc + 1;
}