static int query1(int num, int l, int r) {
    if (a[num].l >= l && a[num].r <= r) {
        return a[num].c;
    } else {
        int m = (a[num].l + a[num].r) >> 1;
        int le = num << 1;
        int ri = le | 1;
        int mi = -1;
        if (r > m) {
            int res = query1(ri, l, r);
            mi = Math.max(mi, res);
        }
        if (l <= m) {
            int res = query1(le, l, r);
            mi = Math.max(mi, res);
        }
        return mi;
    }
}