int findSet(int n) {
    return p[n] = p[n] == n ? n : findSet(p[n]);
}