int findSet(int v) {
    if (v == p[v])
        return v;
    return p[v] = findSet(p[v]);
}