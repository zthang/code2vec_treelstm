static int find(int v) {
    if (par[v] == v)
        return v;
    return par[v] = find(par[v]);
}