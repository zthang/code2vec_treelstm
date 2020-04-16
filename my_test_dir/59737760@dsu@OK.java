static int dsu(int u) {
    return dsu[u] = (u == dsu[u] ? u : dsu(dsu[u]));
}