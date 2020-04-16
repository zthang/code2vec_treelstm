public void update(int node, int lo, int hi, int p, int val) {
    if (lo == hi) {
        a[lo] = val;
        return;
    }
    int m = (lo + hi) / 2;
    if (p <= m)
        update(node * 2, lo, m, p, val);
    else
        update(node * 2 + 1, m + 1, hi, p, val);
    pushUp(node, lo, hi);
}