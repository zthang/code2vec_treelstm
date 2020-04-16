public int getPar(int k) {
    while (k != par[k]) {
        par[k] = par[par[k]];
        k = par[k];
    }
    return k;
}