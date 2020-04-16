public void unite(int x, int y) {
    x = par(x);
    y = par(y);
    if (x == y) {
        return;
    }
    --size;
    parent[x] = y;
    sizee[y] += sizee[x];
}