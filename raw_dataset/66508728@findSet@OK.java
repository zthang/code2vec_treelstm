int findSet(int x) {
    return p[x] == x ? x : (p[x] = findSet(p[x]));
}