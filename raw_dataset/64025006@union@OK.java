boolean union(int x, int y) {
    x = findSet(x);
    y = findSet(y);
    if (x == y)
        return false;
    if (x > y) {
        p[y] = x;
    } else
        p[x] = y;
    return true;
}