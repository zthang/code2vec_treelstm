public void updateRange(int node, int start, int end, int l, int r, int val) {
    if (lazy[node] != 0) {
        seg[node] += lazy[node];
        if (start != end) {
            lazy[2 * node + 1] += lazy[node];
            lazy[2 * node + 2] += lazy[node];
        }
        lazy[node] = 0;
    }
    if (l > end || r < start)
        return;
    if (start >= l && end <= r) {
        seg[node] += val;
        if (start != end) {
            lazy[2 * node + 1] += val;
            lazy[2 * node + 2] += val;
        }
        lazy[node] = 0;
        return;
    }
    int mid = (start + end) / 2;
    updateRange(2 * node + 1, start, mid, l, r, val);
    updateRange(2 * node + 2, mid + 1, end, l, r, val);
    seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
}