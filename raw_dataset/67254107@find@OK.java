private int find(int p) {
    int r = p;
    while (par[r] != r) r = par[r];
    while (r != p) {
        int t = par[p];
        par[p] = r;
        p = t;
    }
    return r;
}