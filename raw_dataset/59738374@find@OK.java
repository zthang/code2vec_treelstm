int find(int x) {
    if (par[x] == x)
        return x;
    else
        return find(par[x]);
}