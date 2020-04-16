static void union(int a, int b) {
    int x = find(a);
    int y = find(b);
    if (r[x] >= r[y]) {
        p[y] = x;
        r[x] += r[y];
    } else {
        p[x] = y;
        r[y] += r[x];
    }
}