private static int mer(int a, int b) {
    int x = gt(a);
    int y = gt(b);
    if (x != y) {
        if (r[x] > r[y]) {
            r[x] += r[y];
            mx[x] = max(mx[x], mx[y]);
            dsu[y] = x;
        } else {
            r[y] += r[x];
            mx[y] = max(mx[y], mx[x]);
            dsu[x] = y;
        }
        return 0;
    }
    return -1;
}