public int find(int x, int[] dsu) {
    return dsu[x] == x ? x : (dsu[x] = find(dsu[x], dsu));
}