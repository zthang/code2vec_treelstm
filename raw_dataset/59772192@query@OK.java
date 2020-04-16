public int query(int v, int vl, int vr, int l, int r) {
    if (l > r)
        return 0;
    if (vl == l && vr == r)
        return t[v];
    int tmp = (vl + vr) / 2;
    return query(2 * v, vl, tmp, l, Math.min(r, tmp)) + query(2 * v + 1, tmp + 1, vr, Math.max(tmp + 1, l), r);
}