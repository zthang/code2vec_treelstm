public int root(int x) {
    return x == p[x] ? x : (p[x] = root(p[x]));
}