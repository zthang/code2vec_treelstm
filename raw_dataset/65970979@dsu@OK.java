static int dsu(int i) {
    return dsu[i] == i ? i : (dsu[i] = dsu(dsu[i]));
}