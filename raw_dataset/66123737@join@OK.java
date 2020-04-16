private void join(int a, int b) {
    int x = root(a), y = root(b);
    if (x != y) {
        if (size[x] < size[y]) {
            int t = x;
            x = y;
            y = t;
        }
        size[x] += size[y];
        root[y] = x;
    }
}