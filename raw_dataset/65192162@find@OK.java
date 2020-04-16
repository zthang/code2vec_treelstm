private int find(int[] p, int x) {
    return p[x] == x ? x : (p[x] = find(p, p[x]));
}