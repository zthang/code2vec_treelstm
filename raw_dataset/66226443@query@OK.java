public long query(int node, int start, int end, int l, int r) {
    if (l > end || r < start)
        return 0;
    if (start >= l && end <= r)
        return seg[node];
    int mid = (start + end) / 2;
    return Math.max(query(2 * node + 1, start, mid, l, r), query(2 * node + 2, mid + 1, end, l, r));
}