private void rangeUpdate(int node, int lo, int hi, int fr, int to, int val) {
    pushDown(node, lo, hi);
    if (lo == fr && hi == to) {
        lazy[node] = val;
        tree[node] = val;
        return;
    }
    int mid = (lo + hi) / 2;
    if (to <= mid) {
        rangeUpdate(node * 2, lo, mid, fr, to, val);
    } else if (fr > mid) {
        rangeUpdate(node * 2 + 1, mid + 1, hi, fr, to, val);
    } else {
        rangeUpdate(node * 2, lo, mid, fr, mid, val);
        rangeUpdate(node * 2 + 1, mid + 1, hi, mid + 1, to, val);
    }
    // combine
    combine(node, lo, hi);
}