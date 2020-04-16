public int queryRange(int node, int start, int end, int l, int r) {
    if (l > end || r < start)
        return 0;
    if (lazy[node] != 0) {
        seg[node] += lazy[node];
        if (start != end) {
            lazy[2 * node + 1] += lazy[node];
            lazy[2 * node + 2] += lazy[node];
        }
        lazy[node] = 0;
    }
    if (start >= l && end <= r)
        return seg[node];
    int mid = (start + end) / 2;
    return (queryRange(2 * node + 1, start, mid, l, r) + queryRange(2 * node + 2, mid + 1, end, l, r));
}