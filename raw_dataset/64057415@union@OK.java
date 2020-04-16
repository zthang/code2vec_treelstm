public boolean union(int x, int y) {
    x = rep(x);
    y = rep(y);
    if (x == y) {
        return false;
    }
    if (size(x) < size(y)) {
        int t = x;
        x = y;
        y = t;
    }
    // now size(x) >= size(y)
    __rep[y] = x;
    __size[x] += __size[y];
    return true;
}