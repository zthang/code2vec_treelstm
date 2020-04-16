static void update(int num, int l, long v) {
    if (a[num].l == a[num].r) {
        a[num].le = v % dd;
        a[num].ri = v % dd;
        a[num].all = v % dd;
        a[num].tot = v % dd;
    } else {
        int m = (a[num].l + a[num].r) >> 1;
        int le = num << 1;
        int ri = le | 1;
        pushdown(num, le, ri);
        if (l <= m) {
            update(le, l, v);
        }
        if (l > m) {
            update(ri, l, v);
        }
        pushup(num, le, ri);
    }
}