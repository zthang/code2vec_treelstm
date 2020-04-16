private int query(int node, int lo, int hi, int fr, int to) {
    if (lazy[node] != -1)
        return tree[node];
    if (lo == fr && hi == to) {
        // System.out.println("found " + tree[node]);
        return tree[node];
    }
    int mid = (lo + hi) / 2;
    if (to <= mid)
        return query(node * 2, lo, mid, fr, to);
    if (mid < fr)
        return query(node * 2 + 1, mid + 1, hi, fr, to);
    return Math.min(query(node * 2, lo, mid, fr, mid), query(node * 2 + 1, mid + 1, hi, mid + 1, to));
}