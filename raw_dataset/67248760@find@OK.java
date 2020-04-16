private static int find(int u) {
    if (u != par[u])
        par[u] = find(par[u]);
    return par[u];
}