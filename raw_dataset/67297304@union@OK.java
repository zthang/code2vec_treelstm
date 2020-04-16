boolean union(int x, int y) {
    x = findSet(x);
    y = findSet(y);
    if (x == y)
        return false;
    if (r[x] > r[y]) {
        p[y] = x;
    } else {
        p[x] = y;
        if (r[x] == r[y])
            r[y]++;
    }
    return true;
}