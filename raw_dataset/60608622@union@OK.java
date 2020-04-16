static int union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return 0;
    p[x] = y;
    return 1;
}