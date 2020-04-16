void dfs(int rt, int fa) {
    vis[rt] = true;
    if (fa != -1) {
        par[rt][0] = fa;
    }
    for (int to : go[rt]) {
        if (to == fa)
            continue;
        w[to][0] = gg[rt][to];
        dfs(to, rt);
    }
}