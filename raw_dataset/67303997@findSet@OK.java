int findSet(int v) {
    if (par[v] == v)
        return v;
    return par[v] = findSet(par[v]);
}