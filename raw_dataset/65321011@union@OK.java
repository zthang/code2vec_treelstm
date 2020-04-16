public boolean union(int x, int y) {
    x = root(x);
    y = root(y);
    if (x != y) {
        if (upper[y] < upper[x]) {
            int d = x;
            x = y;
            y = d;
        }
        min[x] = Math.min(min[x], min[root(y)]);
        max[x] = Math.max(max[x], max[root(y)]);
        upper[x] += upper[y];
        upper[y] = x;
    }
    return x == y;
}