public static int root(int x) {
    while (par[x] != x) {
        par[x] = par[par[x]];
        x = par[par[x]];
    }
    return x;
}