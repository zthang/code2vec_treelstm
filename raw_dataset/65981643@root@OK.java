private int root(int x) {
    if (x == par[x]) {
        return x;
    }
    int root = root(par[x]);
    // cSum
    weight[x] += weight[par[x]];
    par[x] = root;
    return root;
}