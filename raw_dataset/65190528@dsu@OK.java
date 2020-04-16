static int dsu(int x) {
    return dsu[x] == x ? x : (dsu[x] = dsu(dsu[x]));
}