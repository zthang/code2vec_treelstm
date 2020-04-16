private int get(int[] p, int a) {
    int r = a;
    while (p[r] != r) r = p[r];
    int t = a;
    while (p[t] != r) {
        int u = p[t];
        p[t] = r;
        t = u;
    }
    return r;
}