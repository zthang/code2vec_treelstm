int get(int v, int[] dsu) {
    if (dsu[v] == v) {
        return v;
    } else {
        return dsu[v] = get(dsu[v], dsu);
    }
}