void update(int cur, int start, int end, long val, int l, int r, long[] tree, long[] a, long[] lazy) {
    if (l > end || r < start)
        return;
    if (lazy[cur] != 0) {
        tree[cur] += (r - l + 1) * lazy[cur];
        if (l != r) {
            lazy[2 * cur + 1] += lazy[cur];
            lazy[2 * cur + 2] += lazy[cur];
        }
        lazy[cur] = 0;
    }
    if (l >= start && r <= end) {
        tree[cur] += (r - l + 1) * val;
        if (l != r) {
            lazy[cur * 2 + 1] += val;
            lazy[cur * 2 + 2] += val;
        }
        return;
    }
    int mid = (l + r) >> 1;
    update(2 * cur + 1, start, end, val, l, mid, tree, a, lazy);
    update(2 * cur + 2, start, end, val, mid + 1, r, tree, a, lazy);
    tree[cur] = tree[2 * cur + 1] + tree[2 * cur + 2];
}