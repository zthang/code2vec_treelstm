void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x == y)
        return;
    if (h[x] >= h[y]) {
        g[y] = x;
        if (h[x] == h[y])
            h[x]++;
    } else {
        g[x] = y;
    }
}