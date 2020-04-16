int findSet(int v) {
    if (dsu[v] == v) {
        return v;
    }
    int v1 = findSet(dsu[v]);
    dsu[v] = v1;
    return v1;
}