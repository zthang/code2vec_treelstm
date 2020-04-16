public int find(int x) {
    return dsu[x] == x ? x : (dsu[x] = find(dsu[x]));
}