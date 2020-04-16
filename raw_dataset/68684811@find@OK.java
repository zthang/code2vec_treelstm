static int find(int x) {
    return x == p[x] ? x : (p[x] = find(p[x]));
}