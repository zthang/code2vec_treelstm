int find(int u) {
    if (par[u] == u)
        return u;
    return par[u] = find(par[u]);
}