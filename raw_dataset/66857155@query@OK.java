private static int query(Tree tr, int lo, int hi) {
    if (tr == null) {
        return 0;
    }
    if (tr.st == lo && tr.en == hi) {
        return tr.max;
    }
    int mid = (tr.st + tr.en) / 2;
    if (hi <= mid) {
        return query(tr.left, lo, hi);
    }
    if (lo > mid) {
        return query(tr.right, lo, hi);
    }
    return Math.max(query(tr.left, lo, mid), query(tr.right, mid + 1, hi));
}