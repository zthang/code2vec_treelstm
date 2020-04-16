public int rangeQueryMin(int node, int lo, int hi, int fr, int to) {
    if (lo == fr && hi == to)
        return treeMin[node] + lazy[node];
    int mid = (lo + hi) / 2;
    pushDown(node, lo, hi);
    if (to <= mid) {
        return rangeQueryMin(node * 2, lo, mid, fr, to);
    } else if (fr > mid)
        return rangeQueryMin(node * 2 + 1, mid + 1, hi, fr, to);
    else {
        return Math.min(rangeQueryMin(node * 2, lo, mid, fr, mid), rangeQueryMin(node * 2 + 1, mid + 1, hi, mid + 1, to));
    }
}