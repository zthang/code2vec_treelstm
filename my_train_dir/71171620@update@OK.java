public void update(int node, int start, int end, int id, int val) {
    if (start == end) {
        seg[node] = a[start] = val;
        return;
    }
    int mid = (start + end) / 2;
    if (id >= start && id <= mid) {
        update(2 * node + 1, start, mid, id, val);
    } else
        update(2 * node + 2, mid + 1, end, id, val);
    seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
}