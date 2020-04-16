int find(int a) {
    if (par[a] == a)
        return a;
    return par[a] = find(par[a]);
}