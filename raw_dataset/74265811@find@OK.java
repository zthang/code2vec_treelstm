static int find(int i) {
    if (par[i] == i)
        return i;
    return par[i] = find(par[par[i]]);
}