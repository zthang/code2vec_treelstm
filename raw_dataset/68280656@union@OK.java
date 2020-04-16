static void union(int[] g, int[] size, int x, int y) {
    x = find(g, x);
    y = find(g, y);
    if (x == y)
        return;
    if (size[x] < size[y]) {
        g[x] = y;
        size[y] += size[x];
    } else {
        g[y] = x;
        size[x] += size[y];
    }
}