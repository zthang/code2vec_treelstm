int find(int x) {
    if (par[x] != x)
        par[x] = find(par[x]);
    return par[x];
}