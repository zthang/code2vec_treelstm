int root(int n) {
    if (n == par[n])
        return n;
    return par[n] = root(par[n]);
}