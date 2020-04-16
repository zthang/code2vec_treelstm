public int rangeQueryMax(int node, int lo, int hi, int fr, int to) {
    if (lo == fr && hi == to)
        return treeMax[node] + lazy[node];
    int mid = (lo + hi) / 2;
    pushDown(node, lo, hi);
    if (to <= mid) {
        return rangeQueryMax(node * 2, lo, mid, fr, to);
    } else if (fr > mid)
        return rangeQueryMax(node * 2 + 1, mid + 1, hi, fr, to);
    else {
        return Math.max(rangeQueryMax(node * 2, lo, mid, fr, mid), rangeQueryMax(node * 2 + 1, mid + 1, hi, mid + 1, to));
    }
}