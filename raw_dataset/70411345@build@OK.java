static void build(int num, int l, int r) {
    S cur = new S(l, r);
    if (l == r) {
        a[num] = cur;
        return;
    } else {
        int m = (l + r) >> 1;
        int le = num << 1;
        int ri = le | 1;
        build(le, l, m);
        build(ri, m + 1, r);
        a[num] = cur;
        pushup(num, le, ri);
    }
}