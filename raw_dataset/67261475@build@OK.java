void build(int cur, int l, int r, long[] tree, long[] a) {
    if (l == r) {
        tree[cur] = a[l];
        return;
    }
    int mid = (l + r) >> 1;
    build(2 * cur + 1, l, mid, tree, a);
    build(2 * cur + 2, mid + 1, r, tree, a);
    tree[cur] = tree[2 * cur + 1] + tree[2 * cur + 2];
}