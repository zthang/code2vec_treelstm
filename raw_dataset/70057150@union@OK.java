public boolean union(int x, int y) {
    x = root(x);
    y = root(y);
    if (x != y) {
        if (upper[y] < upper[x]) {
            int d = x;
            x = y;
            y = d;
        }
        upper[x] += upper[y];
        upper[y] = x;
        numt[x] += numt[y];
        must[x] |= must[y];
    }
    return x == y;
}