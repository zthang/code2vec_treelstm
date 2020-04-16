private static int find(int u) {
    if (u == par[u])
        return u;
    par[u] = find(par[u]);
    return par[u];
}