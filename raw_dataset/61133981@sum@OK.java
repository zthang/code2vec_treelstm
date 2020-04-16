long sum(int v, int tl, int tr, int l, int r) {
    if (l > r)
        return 0;
    if (l == tl && r == tr)
        return t[v];
    int tm = (tl + tr) / 2;
    return sum(v * 2, tl, tm, l, Math.min(r, tm)) + sum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
}