int root(int i) {
    if (i == par[i]) {
        return i;
    }
    return par[i] = root(par[i]);
}