void build(int p, int s, int e) {
    if (s == e) {
        seg[p] = arr[s][0];
        id[p] = arr[s][1];
        return;
    }
    if (s > e)
        return;
    int m = (s + e) >> 1, l = 2 * p, r = 2 * p + 1;
    build(l, s, m);
    build(r, m + 1, e);
    seg[p] = max(seg[l], seg[r]);
}