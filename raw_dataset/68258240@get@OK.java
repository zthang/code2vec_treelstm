public int get(int v, int tl, int tr, int l, int r) {
    push(v, tl, tr);
    if (l > r) {
        return 0;
    }
    if (l == tl && r == tr) {
        return sum[v];
    }
    int tm = (tl + tr) / 2;
    return f(get(2 * v, tl, tm, l, Math.min(r, tm)), get(2 * v + 1, tm + 1, tr, Math.max(l, tm + 1), r));
}