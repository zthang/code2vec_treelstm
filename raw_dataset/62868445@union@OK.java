public boolean union(int x, int y) {
    x = parent(x);
    y = parent(y);
    if (x == y)
        return false;
    if (r[x] == r[y]) {
        r[x]++;
        p[y] = x;
    } else if (r[x] < r[y]) {
        p[x] = y;
    } else {
        p[y] = x;
    }
    return true;
}