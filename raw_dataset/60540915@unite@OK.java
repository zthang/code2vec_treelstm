void unite(int x, int y) {
    x = get(x);
    y = get(y);
    if (x != y) {
        p[x] = y;
        sz[y] += sz[x];
    }
}