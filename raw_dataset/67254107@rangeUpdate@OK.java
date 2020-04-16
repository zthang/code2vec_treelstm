public void rangeUpdate(int node, int lo, int hi, int fr, int to, int delta) {
    pushDown(node, lo, hi);
    if (fr == lo && to == hi) {
        lazy[node] = delta;
        return;
    }
    int m = (lo + hi) / 2;
    if (to <= m)
        rangeUpdate(node * 2, lo, m, fr, to, delta);
    else if (fr > m)
        rangeUpdate(node * 2 + 1, m + 1, hi, fr, to, delta);
    else {
        rangeUpdate(node * 2, lo, m, fr, m, delta);
        rangeUpdate(node * 2 + 1, m + 1, hi, m + 1, to, delta);
    }
    // re-set the in-variant
    pushUp(node, lo, hi);
}