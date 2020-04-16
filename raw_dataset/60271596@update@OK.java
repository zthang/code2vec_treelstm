public void update(int node, int start, int end, int fi, long fi2) {
    if (start == end) {
        seg[node] = fi2;
        return;
    }
    int mid = (start + end) / 2;
    if (fi >= start && fi <= mid) {
        update(2 * node + 1, start, mid, fi, fi2);
    } else
        update(2 * node + 2, mid + 1, end, fi, fi2);
    seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
}