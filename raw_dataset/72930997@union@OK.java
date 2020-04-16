boolean union(int u, int v) {
    int x = root(u);
    int y = root(v);
    if (x == y)
        return false;
    pt[x] = y;
    return true;
}