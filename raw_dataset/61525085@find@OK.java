public int find(int x) {
    if (par[x] != x) {
        return (par[x] = find(par[x]));
    }
    return x;
}