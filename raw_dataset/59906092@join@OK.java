void join(int u, int v) {
    int x = root(u);
    int y = root(v);
    if (x != y) {
        if (c[y] < c[x]) {
            int d = x;
            x = y;
            y = d;
        }
        c[x] += c[y];
        c[y] = x;
    }
}