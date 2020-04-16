long query(int cur, int l, int r, int start, int end, long[] tree, long[] a, long[] lazy) {
    if (l > end || r < start)
        return 0;
    if (lazy[cur] != 0) {
        tree[cur] += lazy[cur];
        if (l != r) {
            lazy[2 * cur + 1] += lazy[cur];
            lazy[2 * cur + 2] += lazy[cur];
        }
        lazy[cur] = 0;
    }
    if (l >= start && r <= end)
        return tree[cur];
    int mid = (l + r) >> 1;
    long p1 = query(2 * cur + 1, l, mid, start, end, tree, a, lazy);
    long p2 = query(2 * cur + 2, mid + 1, r, start, end, tree, a, lazy);
    return p1 + p2;
}