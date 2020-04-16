int findSet(int i) {
    if (par[i] == i)
        return i;
    par[i] = findSet(par[i]);
    return par[i];
}